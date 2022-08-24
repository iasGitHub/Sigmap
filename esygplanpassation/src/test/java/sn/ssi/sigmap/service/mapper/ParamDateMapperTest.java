package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ParamDateMapperTest {

    private ParamDateMapper paramDateMapper;

    @BeforeEach
    public void setUp() {
        paramDateMapper = new ParamDateMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(paramDateMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(paramDateMapper.fromId(null)).isNull();
    }
}
