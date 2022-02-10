package fr.camss.kata.emplacement.business.poi;

import fr.camss.kata.emplacement.business.poi.model.Area;
import fr.camss.kata.emplacement.business.poi.model.Poi;
import fr.camss.kata.emplacement.business.poi.ports.PoiReader;
import fr.camss.kata.emplacement.business.poi.ports.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
public class PoiServiceImpl implements PoiService {

    private final PoiReader poiReader;

    @Override
    public long getNumberPoisOfArea(final Area area) {
        List<Poi> pois = poiReader.readAllPois();
        return pois.stream().filter(p -> p.isInArea(area))
                .count();
    }

    @Override
    public Set<Area> getNDensestAreas(int n) {
        List<Poi> pois = poiReader.readAllPois();
        Map<Area, List<Poi>> poisByArea = new HashMap<>();

        pois.forEach(p -> p.getAreas()
                .forEach(area -> poisByArea.computeIfAbsent(area, k -> new ArrayList<>()).add(p))
        );

        return poisByArea.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(getSizeListComparator().reversed()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(toSet());
    }

    private static Comparator<List<Poi>> getSizeListComparator() {
        return Comparator.comparing(List::size);
    }
}