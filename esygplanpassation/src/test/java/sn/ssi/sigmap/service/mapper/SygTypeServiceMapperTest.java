package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SygTypeServiceMapperTest {

    private SygTypeServiceMapper sygTypeServiceMapper;

    @BeforeEach
    public void setUp() {
        sygTypeServiceMapper = new SygTypeServiceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sygTypeServiceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sygTypeServiceMapper.fromId(null)).isNull();
    }
}
