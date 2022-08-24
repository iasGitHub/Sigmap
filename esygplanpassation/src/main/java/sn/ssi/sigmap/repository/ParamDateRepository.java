package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ParamDate;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ParamDate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParamDateRepository extends JpaRepository<ParamDate, Long> {
}
