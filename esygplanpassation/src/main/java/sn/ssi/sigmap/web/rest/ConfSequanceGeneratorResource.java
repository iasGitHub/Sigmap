package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.domain.ConfSequanceGenerator;
import sn.ssi.sigmap.service.ConfSequanceGeneratorService;
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
 * REST controller for managing {@link sn.ssi.sigmap.domain.ConfSequanceGenerator}.
 */
@RestController
@RequestMapping("/api")
public class ConfSequanceGeneratorResource {

    private final Logger log = LoggerFactory.getLogger(ConfSequanceGeneratorResource.class);

    private static final String ENTITY_NAME = "planpassationmsConfSequanceGenerator";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConfSequanceGeneratorService confSequanceGeneratorService;

    public ConfSequanceGeneratorResource(ConfSequanceGeneratorService confSequanceGeneratorService) {
        this.confSequanceGeneratorService = confSequanceGeneratorService;
    }

    /**
     * {@code POST  /conf-sequance-generators} : Create a new confSequanceGenerator.
     *
     * @param confSequanceGenerator the confSequanceGenerator to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new confSequanceGenerator, or with status {@code 400 (Bad Request)} if the confSequanceGenerator has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/conf-sequance-generators")
    public ResponseEntity<ConfSequanceGenerator> createConfSequanceGenerator(@Valid @RequestBody ConfSequanceGenerator confSequanceGenerator) throws URISyntaxException {
        log.debug("REST request to save ConfSequanceGenerator : {}", confSequanceGenerator);
        if (confSequanceGenerator.getId() != null) {
            throw new BadRequestAlertException("A new confSequanceGenerator cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ConfSequanceGenerator result = confSequanceGeneratorService.save(confSequanceGenerator);
        return ResponseEntity.created(new URI("/api/conf-sequance-generators/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /conf-sequance-generators} : Updates an existing confSequanceGenerator.
     *
     * @param confSequanceGenerator the confSequanceGenerator to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated confSequanceGenerator,
     * or with status {@code 400 (Bad Request)} if the confSequanceGenerator is not valid,
     * or with status {@code 500 (Internal Server Error)} if the confSequanceGenerator couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/conf-sequance-generators")
    public ResponseEntity<ConfSequanceGenerator> updateConfSequanceGenerator(@Valid @RequestBody ConfSequanceGenerator confSequanceGenerator) throws URISyntaxException {
        log.debug("REST request to update ConfSequanceGenerator : {}", confSequanceGenerator);
        if (confSequanceGenerator.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ConfSequanceGenerator result = confSequanceGeneratorService.save(confSequanceGenerator);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, confSequanceGenerator.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /conf-sequance-generators} : get all the confSequanceGenerators.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of confSequanceGenerators in body.
     */
    @GetMapping("/conf-sequance-generators")
    public ResponseEntity<List<ConfSequanceGenerator>> getAllConfSequanceGenerators(Pageable pageable) {
        log.debug("REST request to get a page of ConfSequanceGenerators");
        Page<ConfSequanceGenerator> page = confSequanceGeneratorService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /conf-sequance-generators/:id} : get the "id" confSequanceGenerator.
     *
     * @param id the id of the confSequanceGenerator to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the confSequanceGenerator, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/conf-sequance-generators/{id}")
    public ResponseEntity<ConfSequanceGenerator> getConfSequanceGenerator(@PathVariable Long id) {
        log.debug("REST request to get ConfSequanceGenerator : {}", id);
        Optional<ConfSequanceGenerator> confSequanceGenerator = confSequanceGeneratorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(confSequanceGenerator);
    }

    /**
     * {@code DELETE  /conf-sequance-generators/:id} : delete the "id" confSequanceGenerator.
     *
     * @param id the id of the confSequanceGenerator to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/conf-sequance-generators/{id}")
    public ResponseEntity<Void> deleteConfSequanceGenerator(@PathVariable Long id) {
        log.debug("REST request to delete ConfSequanceGenerator : {}", id);
        confSequanceGeneratorService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
