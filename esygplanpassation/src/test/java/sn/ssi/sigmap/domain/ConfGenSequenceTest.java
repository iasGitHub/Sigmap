package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ConfGenSequenceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfGenSequence.class);
        ConfGenSequence confGenSequence1 = new ConfGenSequence();
        confGenSequence1.setId(1L);
        ConfGenSequence confGenSequence2 = new ConfGenSequence();
        confGenSequence2.setId(confGenSequence1.getId());
        assertThat(confGenSequence1).isEqualTo(confGenSequence2);
        confGenSequence2.setId(2L);
        assertThat(confGenSequence1).isNotEqualTo(confGenSequence2);
        confGenSequence1.setId(null);
        assertThat(confGenSequence1).isNotEqualTo(confGenSequence2);
    }
}
