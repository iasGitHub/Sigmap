package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygTypeService;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygTypeService entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygTypeServiceRepository extends JpaRepository<SygTypeService, Long>, JpaSpecificationExecutor<SygTypeService> {
}
