package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.SygTypeServiceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.SygTypeService}.
 */
public interface SygTypeServiceService {

    /**
     * Save a sygTypeService.
     *
     * @param sygTypeServiceDTO the entity to save.
     * @return the persisted entity.
     */
    SygTypeServiceDTO save(SygTypeServiceDTO sygTypeServiceDTO);

    /**
     * Get all the sygTypeServices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SygTypeServiceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" sygTypeService.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SygTypeServiceDTO> findOne(Long id);

    /**
     * Delete the "id" sygTypeService.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
