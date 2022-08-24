package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ConfTableRowTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConfTableRow.class);
        ConfTableRow confTableRow1 = new ConfTableRow();
        confTableRow1.setId(1L);
        ConfTableRow confTableRow2 = new ConfTableRow();
        confTableRow2.setId(confTableRow1.getId());
        assertThat(confTableRow1).isEqualTo(confTableRow2);
        confTableRow2.setId(2L);
        assertThat(confTableRow1).isNotEqualTo(confTableRow2);
        confTableRow1.setId(null);
        assertThat(confTableRow1).isNotEqualTo(confTableRow2);
    }
}
