package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ModePassationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ModePassation.class);
        ModePassation modePassation1 = new ModePassation();
        modePassation1.setId(1L);
        ModePassation modePassation2 = new ModePassation();
        modePassation2.setId(modePassation1.getId());
        assertThat(modePassation1).isEqualTo(modePassation2);
        modePassation2.setId(2L);
        assertThat(modePassation1).isNotEqualTo(modePassation2);
        modePassation1.setId(null);
        assertThat(modePassation1).isNotEqualTo(modePassation2);
    }
}
