package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SygServiceMapperTest {

    private SygServiceMapper sygServiceMapper;

    @BeforeEach
    public void setUp() {
        sygServiceMapper = new SygServiceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sygServiceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sygServiceMapper.fromId(null)).isNull();
    }
}
