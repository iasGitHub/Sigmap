package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SygTypeSourceFinancementMapperTest {

    private SygTypeSourceFinancementMapper sygTypeSourceFinancementMapper;

    @BeforeEach
    public void setUp() {
        sygTypeSourceFinancementMapper = new SygTypeSourceFinancementMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sygTypeSourceFinancementMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sygTypeSourceFinancementMapper.fromId(null)).isNull();
    }
}
