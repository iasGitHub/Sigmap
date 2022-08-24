package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.SygSourceFinancementDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.SygSourceFinancement}.
 */
public interface SygSourceFinancementService {

    /**
     * Save a sygSourceFinancement.
     *
     * @param sygSourceFinancementDTO the entity to save.
     * @return the persisted entity.
     */
    SygSourceFinancementDTO save(SygSourceFinancementDTO sygSourceFinancementDTO);

    /**
     * Get all the sygSourceFinancements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SygSourceFinancementDTO> findAll(Pageable pageable);


    /**
     * Get the "id" sygSourceFinancement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SygSourceFinancementDTO> findOne(Long id);

    /**
     * Delete the "id" sygSourceFinancement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
