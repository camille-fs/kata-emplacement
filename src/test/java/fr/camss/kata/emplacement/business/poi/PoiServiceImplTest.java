package fr.camss.kata.emplacement.business.poi;

import fr.camss.kata.emplacement.business.poi.model.Area;
import fr.camss.kata.emplacement.business.poi.ports.PoiReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Set;

import static fr.camss.kata.emplacement.business.poi.helper.PoiDatasetHelper.ALL_POIS;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PoiServiceImplTest {

    private static final Area AREA_1 = Area.builder().minLat(new BigDecimal("-2.5")).
            maxLat(new BigDecimal("-2.0"))
            .minLon((new BigDecimal("38.0")))
            .maxLon((new BigDecimal("38.5"))).build();

    private static final Area AREA_2 = Area.builder().minLat(new BigDecimal("6.5")).
            maxLat(new BigDecimal("7.0"))
            .minLon((new BigDecimal("-7.0")))
            .maxLon((new BigDecimal("-6.5"))).build();

    @InjectMocks
    private PoiServiceImpl poiService;

    @Mock
    private PoiReader poiReader;

    @Test
    void should_number_of_pos_in_area_be_2_when_area_minlat_6_5_and_minlon_7_negate() {
        Mockito.when(poiReader.readAllPois()).thenReturn(ALL_POIS);
        final Area area = new Area(new BigDecimal("6.5"), new BigDecimal("-7.0"));

        final long numberPOIsOfAreaResult = poiService.getNumberPoisOfArea(area);

        assertThat(numberPOIsOfAreaResult).isEqualTo(2);
    }

    @Test
    void should_n_densest_areas_be_minlat_2_5_and_minlat_6_5_when_n_is_2() {
        Mockito.when(poiReader.readAllPois()).thenReturn(ALL_POIS);

        final Set<Area> areas = poiService.getNDensestAreas(2);

        assertThat(areas).containsExactly(AREA_1, AREA_2);
    }

}