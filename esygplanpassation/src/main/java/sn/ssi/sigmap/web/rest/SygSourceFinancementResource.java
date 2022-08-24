package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.SygSourceFinancementService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.SygSourceFinancementDTO;
import sn.ssi.sigmap.service.dto.SygSourceFinancementCriteria;
import sn.ssi.sigmap.service.SygSourceFinancementQueryService;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.SygSourceFinancement}.
 */
@RestController
@RequestMapping("/api")
public class SygSourceFinancementResource {

    private final Logger log = LoggerFactory.getLogger(SygSourceFinancementResource.class);

    private static final String ENTITY_NAME = "planpassationmsSygSourceFinancement";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SygSourceFinancementService sygSourceFinancementService;

    private final SygSourceFinancementQueryService sygSourceFinancementQueryService;

    public SygSourceFinancementResource(SygSourceFinancementService sygSourceFinancementService, SygSourceFinancementQueryService sygSourceFinancementQueryService) {
        this.sygSourceFinancementService = sygSourceFinancementService;
        this.sygSourceFinancementQueryService = sygSourceFinancementQueryService;
    }

    /**
     * {@code POST  /syg-source-financements} : Create a new sygSourceFinancement.
     *
     * @param sygSourceFinancementDTO the sygSourceFinancementDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sygSourceFinancementDTO, or with status {@code 400 (Bad Request)} if the sygSourceFinancement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/syg-source-financements")
    public ResponseEntity<SygSourceFinancementDTO> createSygSourceFinancement(@Valid @RequestBody SygSourceFinancementDTO sygSourceFinancementDTO) throws URISyntaxException {
        log.debug("REST request to save SygSourceFinancement : {}", sygSourceFinancementDTO);
        if (sygSourceFinancementDTO.getId() != null) {
            throw new BadRequestAlertException("A new sygSourceFinancement cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SygSourceFinancementDTO result = sygSourceFinancementService.save(sygSourceFinancementDTO);
        return ResponseEntity.created(new URI("/api/syg-source-financements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /syg-source-financements} : Updates an existing sygSourceFinancement.
     *
     * @param sygSourceFinancementDTO the sygSourceFinancementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sygSourceFinancementDTO,
     * or with status {@code 400 (Bad Request)} if the sygSourceFinancementDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sygSourceFinancementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/syg-source-financements")
    public ResponseEntity<SygSourceFinancementDTO> updateSygSourceFinancement(@Valid @RequestBody SygSourceFinancementDTO sygSourceFinancementDTO) throws URISyntaxException {
        log.debug("REST request to update SygSourceFinancement : {}", sygSourceFinancementDTO);
        if (sygSourceFinancementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SygSourceFinancementDTO result = sygSourceFinancementService.save(sygSourceFinancementDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sygSourceFinancementDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /syg-source-financements} : get all the sygSourceFinancements.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sygSourceFinancements in body.
     */
    @GetMapping("/syg-source-financements")
    public ResponseEntity<List<SygSourceFinancementDTO>> getAllSygSourceFinancements(SygSourceFinancementCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SygSourceFinancements by criteria: {}", criteria);
        Page<SygSourceFinancementDTO> page = sygSourceFinancementQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /syg-source-financements/count} : count all the sygSourceFinancements.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/syg-source-financements/count")
    public ResponseEntity<Long> countSygSourceFinancements(SygSourceFinancementCriteria criteria) {
        log.debug("REST request to count SygSourceFinancements by criteria: {}", criteria);
        return ResponseEntity.ok().body(sygSourceFinancementQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /syg-source-financements/:id} : get the "id" sygSourceFinancement.
     *
     * @param id the id of the sygSourceFinancementDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sygSourceFinancementDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/syg-source-financements/{id}")
    public ResponseEntity<SygSourceFinancementDTO> getSygSourceFinancement(@PathVariable Long id) {
        log.debug("REST request to get SygSourceFinancement : {}", id);
        Optional<SygSourceFinancementDTO> sygSourceFinancementDTO = sygSourceFinancementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sygSourceFinancementDTO);
    }

    /**
     * {@code DELETE  /syg-source-financements/:id} : delete the "id" sygSourceFinancement.
     *
     * @param id the id of the sygSourceFinancementDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/syg-source-financements/{id}")
    public ResponseEntity<Void> deleteSygSourceFinancement(@PathVariable Long id) {
        log.debug("REST request to delete SygSourceFinancement : {}", id);
        sygSourceFinancementService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
