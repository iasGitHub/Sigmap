package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ConfSequanceGeneratorTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfSequanceGenerator.class);
        ConfSequanceGenerator confSequanceGenerator1 = new ConfSequanceGenerator();
        confSequanceGenerator1.setId(1L);
        ConfSequanceGenerator confSequanceGenerator2 = new ConfSequanceGenerator();
        confSequanceGenerator2.setId(confSequanceGenerator1.getId());
        assertThat(confSequanceGenerator1).isEqualTo(confSequanceGenerator2);
        confSequanceGenerator2.setId(2L);
        assertThat(confSequanceGenerator1).isNotEqualTo(confSequanceGenerator2);
        confSequanceGenerator1.setId(null);
        assertThat(confSequanceGenerator1).isNotEqualTo(confSequanceGenerator2);
    }
}
