package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class SygTypeMarcheDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SygTypeMarcheDTO.class);
        SygTypeMarcheDTO sygTypeMarcheDTO1 = new SygTypeMarcheDTO();
        sygTypeMarcheDTO1.setId(1L);
        SygTypeMarcheDTO sygTypeMarcheDTO2 = new SygTypeMarcheDTO();
        assertThat(sygTypeMarcheDTO1).isNotEqualTo(sygTypeMarcheDTO2);
        sygTypeMarcheDTO2.setId(sygTypeMarcheDTO1.getId());
        assertThat(sygTypeMarcheDTO1).isEqualTo(sygTypeMarcheDTO2);
        sygTypeMarcheDTO2.setId(2L);
        assertThat(sygTypeMarcheDTO1).isNotEqualTo(sygTypeMarcheDTO2);
        sygTypeMarcheDTO1.setId(null);
        assertThat(sygTypeMarcheDTO1).isNotEqualTo(sygTypeMarcheDTO2);
    }
}
