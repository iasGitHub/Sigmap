package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.SygRealisation;
import sn.ssi.sigmap.repository.SygRealisationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygRealisation}.
 */
@Service
@Transactional
public class SygRealisationService {

    private final Logger log = LoggerFactory.getLogger(SygRealisationService.class);

    private final SygRealisationRepository sygRealisationRepository;

    public SygRealisationService(SygRealisationRepository sygRealisationRepository) {
        this.sygRealisationRepository = sygRealisationRepository;
    }

    /**
     * Save a sygRealisation.
     *
     * @param sygRealisation the entity to save.
     * @return the persisted entity.
     */
    public SygRealisation save(SygRealisation sygRealisation) {
        log.debug("Request to save SygRealisation : {}", sygRealisation);
        return sygRealisationRepository.save(sygRealisation);
    }

    /**
     * Get all the sygRealisations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SygRealisation> findAll(Pageable pageable) {
        log.debug("Request to get all SygRealisations");
        return sygRealisationRepository.findAll(pageable);
    }


    /**
     * Get one sygRealisation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SygRealisation> findOne(Long id) {
        log.debug("Request to get SygRealisation : {}", id);
        return sygRealisationRepository.findById(id);
    }

    /**
     * Delete the sygRealisation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SygRealisation : {}", id);
        sygRealisationRepository.deleteById(id);
    }
}
