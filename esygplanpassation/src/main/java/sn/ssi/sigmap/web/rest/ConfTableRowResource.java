package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.domain.ConfTableRow;
import sn.ssi.sigmap.service.ConfTableRowService;
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
 * REST controller for managing {@link sn.ssi.sigmap.domain.ConfTableRow}.
 */
@RestController
@RequestMapping("/api")
public class ConfTableRowResource {

    private final Logger log = LoggerFactory.getLogger(ConfTableRowResource.class);

    private static final String ENTITY_NAME = "planpassationmsConfTableRow";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConfTableRowService confTableRowService;

    public ConfTableRowResource(ConfTableRowService confTableRowService) {
        this.confTableRowService = confTableRowService;
    }

    /**
     * {@code POST  /conf-table-rows} : Create a new confTableRow.
     *
     * @param confTableRow the confTableRow to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new confTableRow, or with status {@code 400 (Bad Request)} if the confTableRow has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/conf-table-rows")
    public ResponseEntity<ConfTableRow> createConfTableRow(@Valid @RequestBody ConfTableRow confTableRow) throws URISyntaxException {
        log.debug("REST request to save ConfTableRow : {}", confTableRow);
        if (confTableRow.getId() != null) {
            throw new BadRequestAlertException("A new confTableRow cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ConfTableRow result = confTableRowService.save(confTableRow);
        return ResponseEntity.created(new URI("/api/conf-table-rows/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /conf-table-rows} : Updates an existing confTableRow.
     *
     * @param confTableRow the confTableRow to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated confTableRow,
     * or with status {@code 400 (Bad Request)} if the confTableRow is not valid,
     * or with status {@code 500 (Internal Server Error)} if the confTableRow couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/conf-table-rows")
    public ResponseEntity<ConfTableRow> updateConfTableRow(@Valid @RequestBody ConfTableRow confTableRow) throws URISyntaxException {
        log.debug("REST request to update ConfTableRow : {}", confTableRow);
        if (confTableRow.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ConfTableRow result = confTableRowService.save(confTableRow);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, confTableRow.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /conf-table-rows} : get all the confTableRows.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of confTableRows in body.
     */
    @GetMapping("/conf-table-rows")
    public ResponseEntity<List<ConfTableRow>> getAllConfTableRows(Pageable pageable) {
        log.debug("REST request to get a page of ConfTableRows");
        Page<ConfTableRow> page = confTableRowService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /conf-table-rows/:id} : get the "id" confTableRow.
     *
     * @param id the id of the confTableRow to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the confTableRow, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/conf-table-rows/{id}")
    public ResponseEntity<ConfTableRow> getConfTableRow(@PathVariable Long id) {
        log.debug("REST request to get ConfTableRow : {}", id);
        Optional<ConfTableRow> confTableRow = confTableRowService.findOne(id);
        return ResponseUtil.wrapOrNotFound(confTableRow);
    }

    /**
     * {@code DELETE  /conf-table-rows/:id} : delete the "id" confTableRow.
     *
     * @param id the id of the confTableRow to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/conf-table-rows/{id}")
    public ResponseEntity<Void> deleteConfTableRow(@PathVariable Long id) {
        log.debug("REST request to delete ConfTableRow : {}", id);
        confTableRowService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
