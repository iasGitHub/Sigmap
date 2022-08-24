package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ConfGenSequence;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ConfGenSequence entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfGenSequenceRepository extends JpaRepository<ConfGenSequence, Long> {
}
