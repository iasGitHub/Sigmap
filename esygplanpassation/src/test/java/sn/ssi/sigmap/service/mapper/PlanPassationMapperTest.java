package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlanPassationMapperTest {

    private PlanPassationMapper planPassationMapper;

    @BeforeEach
    public void setUp() {
        planPassationMapper = new PlanPassationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(planPassationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(planPassationMapper.fromId(null)).isNull();
    }
}
