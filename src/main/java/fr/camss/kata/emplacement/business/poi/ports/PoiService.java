package fr.camss.kata.emplacement.business.poi.ports;

import fr.camss.kata.emplacement.business.poi.model.Area;

import java.util.Set;

public interface PoiService {
    long getNumberPoisOfArea(final Area area);

    Set<Area> getNDensestAreas(int n);
}
