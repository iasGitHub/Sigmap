package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.ParamDateDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.ParamDate}.
 */
public interface ParamDateService {

    /**
     * Save a paramDate.
     *
     * @param paramDateDTO the entity to save.
     * @return the persisted entity.
     */
    ParamDateDTO save(ParamDateDTO paramDateDTO);

    /**
     * Get all the paramDates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ParamDateDTO> findAll(Pageable pageable);


    /**
     * Get the "id" paramDate.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ParamDateDTO> findOne(Long id);

    /**
     * Delete the "id" paramDate.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
