package fr.camss.kata.emplacement.business.poi.ports;

import fr.camss.kata.emplacement.business.poi.model.Poi;

import java.util.List;

public interface PoiReader {

    List<Poi> readAllPois();
}
