package fr.camss.kata.emplacement.application.reader;

import fr.camss.kata.emplacement.business.poi.model.Poi;
import fr.camss.kata.emplacement.business.poi.ports.PoiReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.camss.kata.emplacement.business.poi.helper.PoiDatasetHelper.ALL_POIS;
import static org.assertj.core.api.Assertions.assertThat;

class PoiCSVFileReaderTest {

    @Test
    public void should_pois_list_be_complete_when_read_all_pois() {
        PoiReader poiReader = new PoiCSVFileReader();

        List<Poi> poisResult = poiReader.readAllPois();

        assertThat(poisResult).isEqualTo(ALL_POIS);
    }

}