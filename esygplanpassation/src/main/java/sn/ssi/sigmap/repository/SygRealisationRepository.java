package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygRealisation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygRealisation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygRealisationRepository extends JpaRepository<SygRealisation, Long> {
}
