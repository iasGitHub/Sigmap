package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.SygTypeMarcheDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.SygTypeMarche}.
 */
public interface SygTypeMarcheService {

    /**
     * Save a sygTypeMarche.
     *
     * @param sygTypeMarcheDTO the entity to save.
     * @return the persisted entity.
     */
    SygTypeMarcheDTO save(SygTypeMarcheDTO sygTypeMarcheDTO);

    /**
     * Get all the sygTypeMarches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SygTypeMarcheDTO> findAll(Pageable pageable);


    /**
     * Get the "id" sygTypeMarche.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SygTypeMarcheDTO> findOne(Long id);

    /**
     * Delete the "id" sygTypeMarche.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
