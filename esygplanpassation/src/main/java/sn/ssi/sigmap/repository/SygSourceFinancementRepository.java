package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygSourceFinancement;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygSourceFinancement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygSourceFinancementRepository extends JpaRepository<SygSourceFinancement, Long>, JpaSpecificationExecutor<SygSourceFinancement> {
}
