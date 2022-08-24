package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.RealisationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.Realisation}.
 */
public interface RealisationService {

    /**
     * Save a realisation.
     *
     * @param realisationDTO the entity to save.
     * @return the persisted entity.
     */
    RealisationDTO save(RealisationDTO realisationDTO);

    /**
     * Get all the realisations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RealisationDTO> findAll(Pageable pageable);


    /**
     * Get the "id" realisation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RealisationDTO> findOne(Long id);

    /**
     * Delete the "id" realisation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
