package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class SygTypeSourceFinancementTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SygTypeSourceFinancement.class);
        SygTypeSourceFinancement sygTypeSourceFinancement1 = new SygTypeSourceFinancement();
        sygTypeSourceFinancement1.setId(1L);
        SygTypeSourceFinancement sygTypeSourceFinancement2 = new SygTypeSourceFinancement();
        sygTypeSourceFinancement2.setId(sygTypeSourceFinancement1.getId());
        assertThat(sygTypeSourceFinancement1).isEqualTo(sygTypeSourceFinancement2);
        sygTypeSourceFinancement2.setId(2L);
        assertThat(sygTypeSourceFinancement1).isNotEqualTo(sygTypeSourceFinancement2);
        sygTypeSourceFinancement1.setId(null);
        assertThat(sygTypeSourceFinancement1).isNotEqualTo(sygTypeSourceFinancement2);
    }
}
