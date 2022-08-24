package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ConfTableDeTransaction;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ConfTableDeTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfTableDeTransactionRepository extends JpaRepository<ConfTableDeTransaction, Long> {
}
