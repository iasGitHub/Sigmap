package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.Audit;
import sn.ssi.sigmap.repository.AuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Audit}.
 */
@Service
@Transactional
public class AuditService {

    private final Logger log = LoggerFactory.getLogger(AuditService.class);

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    /**
     * Save a audit.
     *
     * @param audit the entity to save.
     * @return the persisted entity.
     */
    public Audit save(Audit audit) {
        log.debug("Request to save Audit : {}", audit);
        return auditRepository.save(audit);
    }

    /**
     * Get all the audits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Audit> findAll(Pageable pageable) {
        log.debug("Request to get all Audits");
        return auditRepository.findAll(pageable);
    }


    /**
     * Get one audit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Audit> findOne(Long id) {
        log.debug("Request to get Audit : {}", id);
        return auditRepository.findById(id);
    }

    /**
     * Delete the audit by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Audit : {}", id);
        auditRepository.deleteById(id);
    }
}
