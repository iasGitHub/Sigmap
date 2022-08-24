package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.domain.ConfTableDeTransaction;
import sn.ssi.sigmap.service.ConfTableDeTransactionService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.ssi.sigmap.domain.ConfTableDeTransaction}.
 */
@RestController
@RequestMapping("/api")
public class ConfTableDeTransactionResource {

    private final Logger log = LoggerFactory.getLogger(ConfTableDeTransactionResource.class);

    private final ConfTableDeTransactionService confTableDeTransactionService;

    public ConfTableDeTransactionResource(ConfTableDeTransactionService confTableDeTransactionService) {
        this.confTableDeTransactionService = confTableDeTransactionService;
    }

    /**
     * {@code GET  /conf-table-de-transactions} : get all the confTableDeTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of confTableDeTransactions in body.
     */
    @GetMapping("/conf-table-de-transactions")
    public ResponseEntity<List<ConfTableDeTransaction>> getAllConfTableDeTransactions(Pageable pageable) {
        log.debug("REST request to get a page of ConfTableDeTransactions");
        Page<ConfTableDeTransaction> page = confTableDeTransactionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /conf-table-de-transactions/:id} : get the "id" confTableDeTransaction.
     *
     * @param id the id of the confTableDeTransaction to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the confTableDeTransaction, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/conf-table-de-transactions/{id}")
    public ResponseEntity<ConfTableDeTransaction> getConfTableDeTransaction(@PathVariable Long id) {
        log.debug("REST request to get ConfTableDeTransaction : {}", id);
        Optional<ConfTableDeTransaction> confTableDeTransaction = confTableDeTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(confTableDeTransaction);
    }
}
