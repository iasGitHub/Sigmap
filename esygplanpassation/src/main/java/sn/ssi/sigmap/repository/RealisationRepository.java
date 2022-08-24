package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.Realisation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Realisation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RealisationRepository extends JpaRepository<Realisation, Long> {
}
