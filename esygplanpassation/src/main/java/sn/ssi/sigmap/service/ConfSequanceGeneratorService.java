package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.ConfSequanceGenerator;
import sn.ssi.sigmap.repository.ConfSequanceGeneratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ConfSequanceGenerator}.
 */
@Service
@Transactional
public class ConfSequanceGeneratorService {

    private final Logger log = LoggerFactory.getLogger(ConfSequanceGeneratorService.class);

    private final ConfSequanceGeneratorRepository confSequanceGeneratorRepository;

    public ConfSequanceGeneratorService(ConfSequanceGeneratorRepository confSequanceGeneratorRepository) {
        this.confSequanceGeneratorRepository = confSequanceGeneratorRepository;
    }

    /**
     * Save a confSequanceGenerator.
     *
     * @param confSequanceGenerator the entity to save.
     * @return the persisted entity.
     */
    public ConfSequanceGenerator save(ConfSequanceGenerator confSequanceGenerator) {
        log.debug("Request to save ConfSequanceGenerator : {}", confSequanceGenerator);
        return confSequanceGeneratorRepository.save(confSequanceGenerator);
    }

    /**
     * Get all the confSequanceGenerators.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ConfSequanceGenerator> findAll(Pageable pageable) {
        log.debug("Request to get all ConfSequanceGenerators");
        return confSequanceGeneratorRepository.findAll(pageable);
    }


    /**
     * Get one confSequanceGenerator by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ConfSequanceGenerator> findOne(Long id) {
        log.debug("Request to get ConfSequanceGenerator : {}", id);
        return confSequanceGeneratorRepository.findById(id);
    }

    /**
     * Delete the confSequanceGenerator by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ConfSequanceGenerator : {}", id);
        confSequanceGeneratorRepository.deleteById(id);
    }
}
