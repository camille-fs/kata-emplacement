package fr.camss.kata.emplacement.business.poi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Area {

    public static final BigDecimal ZONE_SIZE = new BigDecimal("0.5");

    private BigDecimal minLat;

    private BigDecimal maxLat;

    private BigDecimal minLon;

    private BigDecimal maxLon;

    public Area(final BigDecimal minLat, final BigDecimal minLon) {
        this.minLat = minLat;
        this.maxLat = minLat.add(ZONE_SIZE);
        this.minLon = minLon;
        this.maxLon = minLon.add(ZONE_SIZE);
    }
}
