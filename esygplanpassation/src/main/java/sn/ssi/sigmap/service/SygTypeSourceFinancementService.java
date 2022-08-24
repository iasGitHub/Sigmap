package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.SygTypeSourceFinancement}.
 */
public interface SygTypeSourceFinancementService {

    /**
     * Save a sygTypeSourceFinancement.
     *
     * @param sygTypeSourceFinancementDTO the entity to save.
     * @return the persisted entity.
     */
    SygTypeSourceFinancementDTO save(SygTypeSourceFinancementDTO sygTypeSourceFinancementDTO);

    /**
     * Get all the sygTypeSourceFinancements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SygTypeSourceFinancementDTO> findAll(Pageable pageable);


    /**
     * Get the "id" sygTypeSourceFinancement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SygTypeSourceFinancementDTO> findOne(Long id);

    /**
     * Delete the "id" sygTypeSourceFinancement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
