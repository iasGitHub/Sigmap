package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.SygServiceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.SygService}.
 */
public interface SygServiceService {

    /**
     * Save a sygService.
     *
     * @param sygServiceDTO the entity to save.
     * @return the persisted entity.
     */
    SygServiceDTO save(SygServiceDTO sygServiceDTO);

    /**
     * Get all the sygServices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SygServiceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" sygService.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SygServiceDTO> findOne(Long id);

    /**
     * Delete the "id" sygService.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
