package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ConfTableDeTransactionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfTableDeTransaction.class);
        ConfTableDeTransaction confTableDeTransaction1 = new ConfTableDeTransaction();
        confTableDeTransaction1.setId(1L);
        ConfTableDeTransaction confTableDeTransaction2 = new ConfTableDeTransaction();
        confTableDeTransaction2.setId(confTableDeTransaction1.getId());
        assertThat(confTableDeTransaction1).isEqualTo(confTableDeTransaction2);
        confTableDeTransaction2.setId(2L);
        assertThat(confTableDeTransaction1).isNotEqualTo(confTableDeTransaction2);
        confTableDeTransaction1.setId(null);
        assertThat(confTableDeTransaction1).isNotEqualTo(confTableDeTransaction2);
    }
}
