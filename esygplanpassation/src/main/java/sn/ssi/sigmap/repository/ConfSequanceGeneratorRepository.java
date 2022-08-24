package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ConfSequanceGenerator;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ConfSequanceGenerator entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfSequanceGeneratorRepository extends JpaRepository<ConfSequanceGenerator, Long> {
}
