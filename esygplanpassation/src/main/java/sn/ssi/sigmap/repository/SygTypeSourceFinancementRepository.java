package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygTypeSourceFinancement;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygTypeSourceFinancement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygTypeSourceFinancementRepository extends JpaRepository<SygTypeSourceFinancement, Long>, JpaSpecificationExecutor<SygTypeSourceFinancement> {
}
