package sn.ssi.sigmap.service;

import sn.ssi.sigmap.domain.ConfTableDeTransaction;
import sn.ssi.sigmap.repository.ConfTableDeTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ConfTableDeTransaction}.
 */
@Service
@Transactional
public class ConfTableDeTransactionService {

    private final Logger log = LoggerFactory.getLogger(ConfTableDeTransactionService.class);

    private final ConfTableDeTransactionRepository confTableDeTransactionRepository;

    public ConfTableDeTransactionService(ConfTableDeTransactionRepository confTableDeTransactionRepository) {
        this.confTableDeTransactionRepository = confTableDeTransactionRepository;
    }

    /**
     * Save a confTableDeTransaction.
     *
     * @param confTableDeTransaction the entity to save.
     * @return the persisted entity.
     */
    public ConfTableDeTransaction save(ConfTableDeTransaction confTableDeTransaction) {
        log.debug("Request to save ConfTableDeTransaction : {}", confTableDeTransaction);
        return confTableDeTransactionRepository.save(confTableDeTransaction);
    }

    /**
     * Get all the confTableDeTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ConfTableDeTransaction> findAll(Pageable pageable) {
        log.debug("Request to get all ConfTableDeTransactions");
        return confTableDeTransactionRepository.findAll(pageable);
    }


    /**
     * Get one confTableDeTransaction by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ConfTableDeTransaction> findOne(Long id) {
        log.debug("Request to get ConfTableDeTransaction : {}", id);
        return confTableDeTransactionRepository.findById(id);
    }

    /**
     * Delete the confTableDeTransaction by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ConfTableDeTransaction : {}", id);
        confTableDeTransactionRepository.deleteById(id);
    }
}
