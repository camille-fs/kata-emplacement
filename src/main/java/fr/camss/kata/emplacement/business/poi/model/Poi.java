package fr.camss.kata.emplacement.business.poi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import static fr.camss.kata.emplacement.business.poi.model.Area.ZONE_SIZE;
import static java.lang.String.valueOf;

@Data
@Builder
@AllArgsConstructor
public class Poi {

    private static final BigDecimal BIG_DECIMAL_TWO = new BigDecimal("2");
    private String id;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public boolean isInArea(Area area) {
        return isInLongitude(area) && isInLatitude(area);
    }

    private boolean isInLongitude(Area area) {
        return isBetween(longitude, area.getMinLon(), area.getMaxLon());
    }

    private boolean isInLatitude(Area area) {
        return isBetween(latitude, area.getMinLat(), area.getMaxLat());
    }

    private static boolean isBetween(BigDecimal value, BigDecimal start, BigDecimal end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    public Set<Area> getAreas() {
        Set<Area> areas = new HashSet<>();
        BigDecimal lati = new BigDecimal(valueOf(latitude));
        BigDecimal longi = new BigDecimal(valueOf(longitude));

        if (isLatitudeInTwoAreas() && isLongitudeInTwoAreas()) {
            areas.add(new Area(lati, lati.add(ZONE_SIZE), longi, longi.add(ZONE_SIZE)));
            areas.add(new Area(lati, lati.add(ZONE_SIZE), longi, longi.subtract(ZONE_SIZE)));
            areas.add(new Area(lati, lati.subtract(ZONE_SIZE), longi, longi.add(ZONE_SIZE)));
            areas.add(new Area(lati, lati.subtract(ZONE_SIZE), longi, longi.subtract(ZONE_SIZE)));
        }

        if (isLatitudeInTwoAreas() && !isLongitudeInTwoAreas()) {
            areas.add(new Area(lati, lati.add(ZONE_SIZE), roundToHalfDown(longi), roundToHalfUp(longi)));
            areas.add(new Area(lati, lati.subtract(ZONE_SIZE), roundToHalfDown(longi), roundToHalfUp(longi)));
        }

        if (!isLatitudeInTwoAreas() && isLongitudeInTwoAreas()) {
            areas.add(new Area(roundToHalfDown(lati), roundToHalfUp(lati), longi, longi.add(ZONE_SIZE)));
            areas.add(new Area(roundToHalfDown(lati), roundToHalfUp(lati), longi, longi.subtract(ZONE_SIZE)));
        }

        if (!isLatitudeInTwoAreas() && !isLongitudeInTwoAreas()) {
            areas.add(new Area(roundToHalfDown(lati), roundToHalfUp(lati), roundToHalfDown(longi), roundToHalfUp(longi)));
        }

        return areas;
    }

    private boolean isLatitudeInTwoAreas() {
        return latitude.equals(roundToHalf(new BigDecimal(valueOf(latitude))));
    }

    private boolean isLongitudeInTwoAreas() {
        return longitude.equals(roundToHalf(new BigDecimal(valueOf(longitude))));
    }

    private static BigDecimal roundToHalf(BigDecimal value) {
        return BIG_DECIMAL_TWO.multiply(value)
                .setScale(0, RoundingMode.HALF_DOWN)
                .divide(BIG_DECIMAL_TWO, 1, RoundingMode.HALF_DOWN);
    }

    private static BigDecimal roundToHalfDown(BigDecimal value) {
        return BIG_DECIMAL_TWO.multiply(value)
                .setScale(0, RoundingMode.FLOOR)
                .divide(BIG_DECIMAL_TWO, 1, RoundingMode.FLOOR);
    }

    private static BigDecimal roundToHalfUp(BigDecimal value) {
        return BIG_DECIMAL_TWO.multiply(value)
                .setScale(0, RoundingMode.CEILING)
                .divide(BIG_DECIMAL_TWO, 1, RoundingMode.CEILING);
    }
}
