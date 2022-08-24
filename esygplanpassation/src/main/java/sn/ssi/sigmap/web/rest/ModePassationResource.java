package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.domain.ModePassation;
import sn.ssi.sigmap.repository.ModePassationRepository;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.ssi.sigmap.domain.ModePassation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ModePassationResource {

    private final Logger log = LoggerFactory.getLogger(ModePassationResource.class);

    private static final String ENTITY_NAME = "planpassationmsModePassation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ModePassationRepository modePassationRepository;

    public ModePassationResource(ModePassationRepository modePassationRepository) {
        this.modePassationRepository = modePassationRepository;
    }

    /**
     * {@code POST  /mode-passations} : Create a new modePassation.
     *
     * @param modePassation the modePassation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new modePassation, or with status {@code 400 (Bad Request)} if the modePassation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mode-passations")
    public ResponseEntity<ModePassation> createModePassation(@Valid @RequestBody ModePassation modePassation) throws URISyntaxException {
        log.debug("REST request to save ModePassation : {}", modePassation);
        if (modePassation.getId() != null) {
            throw new BadRequestAlertException("A new modePassation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ModePassation result = modePassationRepository.save(modePassation);
        return ResponseEntity.created(new URI("/api/mode-passations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mode-passations} : Updates an existing modePassation.
     *
     * @param modePassation the modePassation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated modePassation,
     * or with status {@code 400 (Bad Request)} if the modePassation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the modePassation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mode-passations")
    public ResponseEntity<ModePassation> updateModePassation(@Valid @RequestBody ModePassation modePassation) throws URISyntaxException {
        log.debug("REST request to update ModePassation : {}", modePassation);
        if (modePassation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ModePassation result = modePassationRepository.save(modePassation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, modePassation.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mode-passations} : get all the modePassations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of modePassations in body.
     */
    @GetMapping("/mode-passations")
    public List<ModePassation> getAllModePassations() {
        log.debug("REST request to get all ModePassations");
        return modePassationRepository.findAll();
    }

    /**
     * {@code GET  /mode-passations/:id} : get the "id" modePassation.
     *
     * @param id the id of the modePassation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the modePassation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mode-passations/{id}")
    public ResponseEntity<ModePassation> getModePassation(@PathVariable Long id) {
        log.debug("REST request to get ModePassation : {}", id);
        Optional<ModePassation> modePassation = modePassationRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(modePassation);
    }

    /**
     * {@code DELETE  /mode-passations/:id} : delete the "id" modePassation.
     *
     * @param id the id of the modePassation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mode-passations/{id}")
    public ResponseEntity<Void> deleteModePassation(@PathVariable Long id) {
        log.debug("REST request to delete ModePassation : {}", id);
        modePassationRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
