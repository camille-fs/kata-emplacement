package fr.camss.kata.emplacement.application.reader;

import fr.camss.kata.emplacement.business.poi.model.Poi;
import fr.camss.kata.emplacement.business.poi.ports.PoiReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakePoiReader implements PoiReader {

    @Override
    public List<Poi> readAllPois() {
        return new ArrayList<>();
    }
}
