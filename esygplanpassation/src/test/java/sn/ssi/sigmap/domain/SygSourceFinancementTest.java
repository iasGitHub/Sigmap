package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class SygSourceFinancementTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SygSourceFinancement.class);
        SygSourceFinancement sygSourceFinancement1 = new SygSourceFinancement();
        sygSourceFinancement1.setId(1L);
        SygSourceFinancement sygSourceFinancement2 = new SygSourceFinancement();
        sygSourceFinancement2.setId(sygSourceFinancement1.getId());
        assertThat(sygSourceFinancement1).isEqualTo(sygSourceFinancement2);
        sygSourceFinancement2.setId(2L);
        assertThat(sygSourceFinancement1).isNotEqualTo(sygSourceFinancement2);
        sygSourceFinancement1.setId(null);
        assertThat(sygSourceFinancement1).isNotEqualTo(sygSourceFinancement2);
    }
}
