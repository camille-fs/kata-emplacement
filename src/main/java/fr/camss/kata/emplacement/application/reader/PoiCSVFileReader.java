package fr.camss.kata.emplacement.application.reader;

import fr.camss.kata.emplacement.business.poi.model.Poi;
import fr.camss.kata.emplacement.business.poi.ports.PoiReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class PoiCSVFileReader implements PoiReader {

    private static final String POI_CSV_FILE_PATH = "POIs.csv";
    private static final String ID = "@id";
    private static final String LAT = "@lat";
    private static final String LON = "@lon";

    Logger logger = LoggerFactory.getLogger(PoiCSVFileReader.class);

    @Override
    public List<Poi> readAllPois() {
        List<Poi> pois = new ArrayList<>();

        try {
            Reader reader = new FileReader((new ClassPathResource(POI_CSV_FILE_PATH)).getFile());

            pois = CSVFormat.DEFAULT.builder()
                    .setHeader(ID, LAT, LON)
                    .setSkipHeaderRecord(true)
                    .setTrim(true).build()
                    .parse(reader)
                    .stream()
                    .map(mapCsvRecordToPoi())
                    .toList();

        } catch (FileNotFoundException e) {
            logger.error("File not found at path : " + POI_CSV_FILE_PATH, e);
        } catch (IOException e) {
            logger.error("Error when trying to parse the csv file at path : " + POI_CSV_FILE_PATH, e);
        }
        return pois;
    }

    private Function<CSVRecord, Poi> mapCsvRecordToPoi() {
        return record -> new Poi(record.get(ID), new BigDecimal(record.get(LAT)), new BigDecimal(record.get(LON)));
    }
}
