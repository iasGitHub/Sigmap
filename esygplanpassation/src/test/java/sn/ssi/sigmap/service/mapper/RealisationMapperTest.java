package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RealisationMapperTest {

    private RealisationMapper realisationMapper;

    @BeforeEach
    public void setUp() {
        realisationMapper = new RealisationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(realisationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(realisationMapper.fromId(null)).isNull();
    }
}
