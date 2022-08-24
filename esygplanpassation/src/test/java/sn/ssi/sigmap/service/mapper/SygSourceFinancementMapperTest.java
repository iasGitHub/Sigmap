package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SygSourceFinancementMapperTest {

    private SygSourceFinancementMapper sygSourceFinancementMapper;

    @BeforeEach
    public void setUp() {
        sygSourceFinancementMapper = new SygSourceFinancementMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sygSourceFinancementMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sygSourceFinancementMapper.fromId(null)).isNull();
    }
}
