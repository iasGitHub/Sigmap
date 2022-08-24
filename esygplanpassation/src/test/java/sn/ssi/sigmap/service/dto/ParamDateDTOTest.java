package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ParamDateDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ParamDateDTO.class);
        ParamDateDTO paramDateDTO1 = new ParamDateDTO();
        paramDateDTO1.setId(1L);
        ParamDateDTO paramDateDTO2 = new ParamDateDTO();
        assertThat(paramDateDTO1).isNotEqualTo(paramDateDTO2);
        paramDateDTO2.setId(paramDateDTO1.getId());
        assertThat(paramDateDTO1).isEqualTo(paramDateDTO2);
        paramDateDTO2.setId(2L);
        assertThat(paramDateDTO1).isNotEqualTo(paramDateDTO2);
        paramDateDTO1.setId(null);
        assertThat(paramDateDTO1).isNotEqualTo(paramDateDTO2);
    }
}
