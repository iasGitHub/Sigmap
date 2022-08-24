package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.SygTypeSourceFinancementService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementDTO;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementCriteria;
import sn.ssi.sigmap.service.SygTypeSourceFinancementQueryService;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.SygTypeSourceFinancement}.
 */
@RestController
@RequestMapping("/api")
public class SygTypeSourceFinancementResource {

    private final Logger log = LoggerFactory.getLogger(SygTypeSourceFinancementResource.class);

    private static final String ENTITY_NAME = "planpassationmsSygTypeSourceFinancement";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SygTypeSourceFinancementService sygTypeSourceFinancementService;

    private final SygTypeSourceFinancementQueryService sygTypeSourceFinancementQueryService;

    public SygTypeSourceFinancementResource(SygTypeSourceFinancementService sygTypeSourceFinancementService, SygTypeSourceFinancementQueryService sygTypeSourceFinancementQueryService) {
        this.sygTypeSourceFinancementService = sygTypeSourceFinancementService;
        this.sygTypeSourceFinancementQueryService = sygTypeSourceFinancementQueryService;
    }

    /**
     * {@code POST  /syg-type-source-financements} : Create a new sygTypeSourceFinancement.
     *
     * @param sygTypeSourceFinancementDTO the sygTypeSourceFinancementDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sygTypeSourceFinancementDTO, or with status {@code 400 (Bad Request)} if the sygTypeSourceFinancement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/syg-type-source-financements")
    public ResponseEntity<SygTypeSourceFinancementDTO> createSygTypeSourceFinancement(@Valid @RequestBody SygTypeSourceFinancementDTO sygTypeSourceFinancementDTO) throws URISyntaxException {
        log.debug("REST request to save SygTypeSourceFinancement : {}", sygTypeSourceFinancementDTO);
        if (sygTypeSourceFinancementDTO.getId() != null) {
            throw new BadRequestAlertException("A new sygTypeSourceFinancement cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SygTypeSourceFinancementDTO result = sygTypeSourceFinancementService.save(sygTypeSourceFinancementDTO);
        return ResponseEntity.created(new URI("/api/syg-type-source-financements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /syg-type-source-financements} : Updates an existing sygTypeSourceFinancement.
     *
     * @param sygTypeSourceFinancementDTO the sygTypeSourceFinancementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sygTypeSourceFinancementDTO,
     * or with status {@code 400 (Bad Request)} if the sygTypeSourceFinancementDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sygTypeSourceFinancementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/syg-type-source-financements")
    public ResponseEntity<SygTypeSourceFinancementDTO> updateSygTypeSourceFinancement(@Valid @RequestBody SygTypeSourceFinancementDTO sygTypeSourceFinancementDTO) throws URISyntaxException {
        log.debug("REST request to update SygTypeSourceFinancement : {}", sygTypeSourceFinancementDTO);
        if (sygTypeSourceFinancementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SygTypeSourceFinancementDTO result = sygTypeSourceFinancementService.save(sygTypeSourceFinancementDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sygTypeSourceFinancementDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /syg-type-source-financements} : get all the sygTypeSourceFinancements.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sygTypeSourceFinancements in body.
     */
    @GetMapping("/syg-type-source-financements")
    public ResponseEntity<List<SygTypeSourceFinancementDTO>> getAllSygTypeSourceFinancements(SygTypeSourceFinancementCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SygTypeSourceFinancements by criteria: {}", criteria);
        Page<SygTypeSourceFinancementDTO> page = sygTypeSourceFinancementQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /syg-type-source-financements/count} : count all the sygTypeSourceFinancements.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/syg-type-source-financements/count")
    public ResponseEntity<Long> countSygTypeSourceFinancements(SygTypeSourceFinancementCriteria criteria) {
        log.debug("REST request to count SygTypeSourceFinancements by criteria: {}", criteria);
        return ResponseEntity.ok().body(sygTypeSourceFinancementQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /syg-type-source-financements/:id} : get the "id" sygTypeSourceFinancement.
     *
     * @param id the id of the sygTypeSourceFinancementDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sygTypeSourceFinancementDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/syg-type-source-financements/{id}")
    public ResponseEntity<SygTypeSourceFinancementDTO> getSygTypeSourceFinancement(@PathVariable Long id) {
        log.debug("REST request to get SygTypeSourceFinancement : {}", id);
        Optional<SygTypeSourceFinancementDTO> sygTypeSourceFinancementDTO = sygTypeSourceFinancementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sygTypeSourceFinancementDTO);
    }

    /**
     * {@code DELETE  /syg-type-source-financements/:id} : delete the "id" sygTypeSourceFinancement.
     *
     * @param id the id of the sygTypeSourceFinancementDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/syg-type-source-financements/{id}")
    public ResponseEntity<Void> deleteSygTypeSourceFinancement(@PathVariable Long id) {
        log.debug("REST request to delete SygTypeSourceFinancement : {}", id);
        sygTypeSourceFinancementService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
