package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.ConfGenSequence;
import sn.ssi.sigmap.repository.ConfGenSequenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ConfGenSequence}.
 */
@Service
@Transactional
public class ConfGenSequenceService {

    private final Logger log = LoggerFactory.getLogger(ConfGenSequenceService.class);

    private final ConfGenSequenceRepository confGenSequenceRepository;

    public ConfGenSequenceService(ConfGenSequenceRepository confGenSequenceRepository) {
        this.confGenSequenceRepository = confGenSequenceRepository;
    }

    /**
     * Save a confGenSequence.
     *
     * @param confGenSequence the entity to save.
     * @return the persisted entity.
     */
    public ConfGenSequence save(ConfGenSequence confGenSequence) {
        log.debug("Request to save ConfGenSequence : {}", confGenSequence);
        return confGenSequenceRepository.save(confGenSequence);
    }

    /**
     * Get all the confGenSequences.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ConfGenSequence> findAll(Pageable pageable) {
        log.debug("Request to get all ConfGenSequences");
        return confGenSequenceRepository.findAll(pageable);
    }


    /**
     * Get one confGenSequence by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ConfGenSequence> findOne(Long id) {
        log.debug("Request to get ConfGenSequence : {}", id);
        return confGenSequenceRepository.findById(id);
    }

    /**
     * Delete the confGenSequence by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ConfGenSequence : {}", id);
        confGenSequenceRepository.deleteById(id);
    }
}
