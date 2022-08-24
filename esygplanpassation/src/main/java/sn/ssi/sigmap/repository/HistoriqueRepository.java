package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.Historique;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Historique entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}
