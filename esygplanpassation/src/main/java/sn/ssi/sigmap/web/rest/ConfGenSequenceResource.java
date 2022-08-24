package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.domain.ConfGenSequence;
import sn.ssi.sigmap.service.ConfGenSequenceService;
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
 * REST controller for managing {@link sn.ssi.sigmap.domain.ConfGenSequence}.
 */
@RestController
@RequestMapping("/api")
public class ConfGenSequenceResource {

    private final Logger log = LoggerFactory.getLogger(ConfGenSequenceResource.class);

    private static final String ENTITY_NAME = "planpassationmsConfGenSequence";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConfGenSequenceService confGenSequenceService;

    public ConfGenSequenceResource(ConfGenSequenceService confGenSequenceService) {
        this.confGenSequenceService = confGenSequenceService;
    }

    /**
     * {@code POST  /conf-gen-sequences} : Create a new confGenSequence.
     *
     * @param confGenSequence the confGenSequence to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new confGenSequence, or with status {@code 400 (Bad Request)} if the confGenSequence has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/conf-gen-sequences")
    public ResponseEntity<ConfGenSequence> createConfGenSequence(@Valid @RequestBody ConfGenSequence confGenSequence) throws URISyntaxException {
        log.debug("REST request to save ConfGenSequence : {}", confGenSequence);
        if (confGenSequence.getId() != null) {
            throw new BadRequestAlertException("A new confGenSequence cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ConfGenSequence result = confGenSequenceService.save(confGenSequence);
        return ResponseEntity.created(new URI("/api/conf-gen-sequences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /conf-gen-sequences} : Updates an existing confGenSequence.
     *
     * @param confGenSequence the confGenSequence to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated confGenSequence,
     * or with status {@code 400 (Bad Request)} if the confGenSequence is not valid,
     * or with status {@code 500 (Internal Server Error)} if the confGenSequence couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/conf-gen-sequences")
    public ResponseEntity<ConfGenSequence> updateConfGenSequence(@Valid @RequestBody ConfGenSequence confGenSequence) throws URISyntaxException {
        log.debug("REST request to update ConfGenSequence : {}", confGenSequence);
        if (confGenSequence.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ConfGenSequence result = confGenSequenceService.save(confGenSequence);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, confGenSequence.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /conf-gen-sequences} : get all the confGenSequences.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of confGenSequences in body.
     */
    @GetMapping("/conf-gen-sequences")
    public ResponseEntity<List<ConfGenSequence>> getAllConfGenSequences(Pageable pageable) {
        log.debug("REST request to get a page of ConfGenSequences");
        Page<ConfGenSequence> page = confGenSequenceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /conf-gen-sequences/:id} : get the "id" confGenSequence.
     *
     * @param id the id of the confGenSequence to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the confGenSequence, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/conf-gen-sequences/{id}")
    public ResponseEntity<ConfGenSequence> getConfGenSequence(@PathVariable Long id) {
        log.debug("REST request to get ConfGenSequence : {}", id);
        Optional<ConfGenSequence> confGenSequence = confGenSequenceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(confGenSequence);
    }

    /**
     * {@code DELETE  /conf-gen-sequences/:id} : delete the "id" confGenSequence.
     *
     * @param id the id of the confGenSequence to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/conf-gen-sequences/{id}")
    public ResponseEntity<Void> deleteConfGenSequence(@PathVariable Long id) {
        log.debug("REST request to delete ConfGenSequence : {}", id);
        confGenSequenceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
