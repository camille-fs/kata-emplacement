package fr.camss.kata.emplacement.business.poi.helper;

import fr.camss.kata.emplacement.business.poi.model.Poi;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PoiDatasetHelper {

    public static final Poi POI_1 = Poi.builder().id("id1").latitude(new BigDecimal("48.6").negate()).longitude(new BigDecimal("37.7").negate()).build();
    public static final Poi POI_2 = Poi.builder().id("id2").latitude(new BigDecimal("27.1").negate()).longitude(new BigDecimal("8.4")).build();
    public static final Poi POI_3 = Poi.builder().id("id3").latitude(new BigDecimal("6.6")).longitude(new BigDecimal("6.9").negate()).build();
    public static final Poi POI_4 = Poi.builder().id("id4").latitude(new BigDecimal("2.3").negate()).longitude(new BigDecimal("38.3")).build();
    public static final Poi POI_5 = Poi.builder().id("id5").latitude(new BigDecimal("6.8")).longitude(new BigDecimal("6.9").negate()).build();
    public static final Poi POI_6 = Poi.builder().id("id6").latitude(new BigDecimal("2.5").negate()).longitude(new BigDecimal("38.3")).build();
    public static final Poi POI_7 = Poi.builder().id("id7").latitude(new BigDecimal("0.1")).longitude(new BigDecimal("0.1").negate()).build();
    public static final Poi POI_8 = Poi.builder().id("id8").latitude(new BigDecimal("2.1").negate()).longitude(new BigDecimal("38.1")).build();

    public static final List<Poi> ALL_POIS = List.of(POI_1, POI_2, POI_3, POI_4, POI_5, POI_6, POI_7, POI_8);

}
