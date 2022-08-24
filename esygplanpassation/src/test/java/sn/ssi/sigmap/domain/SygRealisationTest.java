package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class SygRealisationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SygRealisation.class);
        SygRealisation sygRealisation1 = new SygRealisation();
        sygRealisation1.setId(1L);
        SygRealisation sygRealisation2 = new SygRealisation();
        sygRealisation2.setId(sygRealisation1.getId());
        assertThat(sygRealisation1).isEqualTo(sygRealisation2);
        sygRealisation2.setId(2L);
        assertThat(sygRealisation1).isNotEqualTo(sygRealisation2);
        sygRealisation1.setId(null);
        assertThat(sygRealisation1).isNotEqualTo(sygRealisation2);
    }
}
