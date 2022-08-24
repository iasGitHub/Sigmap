package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.ConfTableRow;
import sn.ssi.sigmap.repository.ConfTableRowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ConfTableRow}.
 */
@Service
@Transactional
public class ConfTableRowService {

    private final Logger log = LoggerFactory.getLogger(ConfTableRowService.class);

    private final ConfTableRowRepository confTableRowRepository;

    public ConfTableRowService(ConfTableRowRepository confTableRowRepository) {
        this.confTableRowRepository = confTableRowRepository;
    }

    /**
     * Save a confTableRow.
     *
     * @param confTableRow the entity to save.
     * @return the persisted entity.
     */
    public ConfTableRow save(ConfTableRow confTableRow) {
        log.debug("Request to save ConfTableRow : {}", confTableRow);
        return confTableRowRepository.save(confTableRow);
    }

    /**
     * Get all the confTableRows.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ConfTableRow> findAll(Pageable pageable) {
        log.debug("Request to get all ConfTableRows");
        return confTableRowRepository.findAll(pageable);
    }


    /**
     * Get one confTableRow by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ConfTableRow> findOne(Long id) {
        log.debug("Request to get ConfTableRow : {}", id);
        return confTableRowRepository.findById(id);
    }

    /**
     * Delete the confTableRow by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ConfTableRow : {}", id);
        confTableRowRepository.deleteById(id);
    }
}
