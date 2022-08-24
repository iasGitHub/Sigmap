package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class RealisationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RealisationDTO.class);
        RealisationDTO realisationDTO1 = new RealisationDTO();
        realisationDTO1.setId(1L);
        RealisationDTO realisationDTO2 = new RealisationDTO();
        assertThat(realisationDTO1).isNotEqualTo(realisationDTO2);
        realisationDTO2.setId(realisationDTO1.getId());
        assertThat(realisationDTO1).isEqualTo(realisationDTO2);
        realisationDTO2.setId(2L);
        assertThat(realisationDTO1).isNotEqualTo(realisationDTO2);
        realisationDTO1.setId(null);
        assertThat(realisationDTO1).isNotEqualTo(realisationDTO2);
    }
}
