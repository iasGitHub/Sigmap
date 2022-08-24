package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.RealisationService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.RealisationDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.Realisation}.
 */
@RestController
@RequestMapping("/api")
public class RealisationResource {

    private final Logger log = LoggerFactory.getLogger(RealisationResource.class);

    private static final String ENTITY_NAME = "planpassationmsRealisation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RealisationService realisationService;

    public RealisationResource(RealisationService realisationService) {
        this.realisationService = realisationService;
    }

    /**
     * {@code POST  /realisations} : Create a new realisation.
     *
     * @param realisationDTO the realisationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new realisationDTO, or with status {@code 400 (Bad Request)} if the realisation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/realisations")
    public ResponseEntity<RealisationDTO> createRealisation(@Valid @RequestBody RealisationDTO realisationDTO) throws URISyntaxException {
        log.debug("REST request to save Realisation : {}", realisationDTO);
        if (realisationDTO.getId() != null) {
            throw new BadRequestAlertException("A new realisation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RealisationDTO result = realisationService.save(realisationDTO);
        return ResponseEntity.created(new URI("/api/realisations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /realisations} : Updates an existing realisation.
     *
     * @param realisationDTO the realisationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated realisationDTO,
     * or with status {@code 400 (Bad Request)} if the realisationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the realisationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/realisations")
    public ResponseEntity<RealisationDTO> updateRealisation(@Valid @RequestBody RealisationDTO realisationDTO) throws URISyntaxException {
        log.debug("REST request to update Realisation : {}", realisationDTO);
        if (realisationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RealisationDTO result = realisationService.save(realisationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, realisationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /realisations} : get all the realisations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of realisations in body.
     */
    @GetMapping("/realisations")
    public ResponseEntity<List<RealisationDTO>> getAllRealisations(Pageable pageable) {
        log.debug("REST request to get a page of Realisations");
        Page<RealisationDTO> page = realisationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /realisations/:id} : get the "id" realisation.
     *
     * @param id the id of the realisationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the realisationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/realisations/{id}")
    public ResponseEntity<RealisationDTO> getRealisation(@PathVariable Long id) {
        log.debug("REST request to get Realisation : {}", id);
        Optional<RealisationDTO> realisationDTO = realisationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(realisationDTO);
    }

    /**
     * {@code DELETE  /realisations/:id} : delete the "id" realisation.
     *
     * @param id the id of the realisationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/realisations/{id}")
    public ResponseEntity<Void> deleteRealisation(@PathVariable Long id) {
        log.debug("REST request to delete Realisation : {}", id);
        realisationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
