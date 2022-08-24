package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygService;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygService entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygServiceRepository extends JpaRepository<SygService, Long>, JpaSpecificationExecutor<SygService> {
}
