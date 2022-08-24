package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ModePassation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ModePassation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModePassationRepository extends JpaRepository<ModePassation, Long> {
}
