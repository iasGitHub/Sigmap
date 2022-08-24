package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class SygTypeServiceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SygTypeService.class);
        SygTypeService sygTypeService1 = new SygTypeService();
        sygTypeService1.setId(1L);
        SygTypeService sygTypeService2 = new SygTypeService();
        sygTypeService2.setId(sygTypeService1.getId());
        assertThat(sygTypeService1).isEqualTo(sygTypeService2);
        sygTypeService2.setId(2L);
        assertThat(sygTypeService1).isNotEqualTo(sygTypeService2);
        sygTypeService1.setId(null);
        assertThat(sygTypeService1).isNotEqualTo(sygTypeService2);
    }
}
