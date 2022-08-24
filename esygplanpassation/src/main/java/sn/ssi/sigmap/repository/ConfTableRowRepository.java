package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ConfTableRow;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ConfTableRow entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfTableRowRepository extends JpaRepository<ConfTableRow, Long> {
}
