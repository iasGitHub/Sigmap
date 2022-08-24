package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PlanPassationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlanPassationDTO.class);
        PlanPassationDTO planPassationDTO1 = new PlanPassationDTO();
        planPassationDTO1.setId(1L);
        PlanPassationDTO planPassationDTO2 = new PlanPassationDTO();
        assertThat(planPassationDTO1).isNotEqualTo(planPassationDTO2);
        planPassationDTO2.setId(planPassationDTO1.getId());
        assertThat(planPassationDTO1).isEqualTo(planPassationDTO2);
        planPassationDTO2.setId(2L);
        assertThat(planPassationDTO1).isNotEqualTo(planPassationDTO2);
        planPassationDTO1.setId(null);
        assertThat(planPassationDTO1).isNotEqualTo(planPassationDTO2);
    }
}
