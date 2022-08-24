package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.SygTypeMarche;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SygTypeMarche entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SygTypeMarcheRepository extends JpaRepository<SygTypeMarche, Long>, JpaSpecificationExecutor<SygTypeMarche> {
}
