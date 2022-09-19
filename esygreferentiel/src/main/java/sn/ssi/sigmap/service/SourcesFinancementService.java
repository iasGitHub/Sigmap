package sn.ssi.sigmap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.ssi.sigmap.service.dto.SourcesFinancementDTO;

import java.util.Optional;


public interface SourcesFinancementService {
    /**
     * Save a typeSourceFinancement.
     *
     * @param sourcesFinancementDTO the entity to save.
     * @return the persisted entity.
     */
    SourcesFinancementDTO save(SourcesFinancementDTO sourcesFinancementDTO);

    /**
     * Updates a typeSourceFinancement.
     *
     * @param sourcesFinancementDTO the entity to update.
     * @return the persisted entity.
     */
    SourcesFinancementDTO update(SourcesFinancementDTO sourcesFinancementDTO);

    /**
     * Partially updates a typeSourceFinancement.
     *
     * @param sourcesFinancementDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SourcesFinancementDTO> partialUpdate(SourcesFinancementDTO sourcesFinancementDTO);

    /**
     * Get all the typeSourceFinancements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SourcesFinancementDTO> findAll(Pageable pageable);

    /**
     * Get the "id" typeSourceFinancement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SourcesFinancementDTO> findOne(Long id);

    /**
     * Delete the "id" typeSourceFinancement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
