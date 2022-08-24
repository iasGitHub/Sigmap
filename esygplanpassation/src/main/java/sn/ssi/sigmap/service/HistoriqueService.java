package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.HistoriqueDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.Historique}.
 */
public interface HistoriqueService {

    /**
     * Save a historique.
     *
     * @param historiqueDTO the entity to save.
     * @return the persisted entity.
     */
    HistoriqueDTO save(HistoriqueDTO historiqueDTO);

    /**
     * Get all the historiques.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<HistoriqueDTO> findAll(Pageable pageable);


    /**
     * Get the "id" historique.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<HistoriqueDTO> findOne(Long id);

    /**
     * Delete the "id" historique.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
