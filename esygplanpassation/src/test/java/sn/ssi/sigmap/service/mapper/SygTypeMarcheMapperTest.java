package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SygTypeMarcheMapperTest {

    private SygTypeMarcheMapper sygTypeMarcheMapper;

    @BeforeEach
    public void setUp() {
        sygTypeMarcheMapper = new SygTypeMarcheMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sygTypeMarcheMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sygTypeMarcheMapper.fromId(null)).isNull();
    }
}
