package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.SygServiceService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.SygServiceDTO;
import sn.ssi.sigmap.service.dto.SygServiceCriteria;
import sn.ssi.sigmap.service.SygServiceQueryService;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.SygService}.
 */
@RestController
@RequestMapping("/api")
public class SygServiceResource {

    private final Logger log = LoggerFactory.getLogger(SygServiceResource.class);

    private static final String ENTITY_NAME = "planpassationmsSygService";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SygServiceService sygServiceService;

    private final SygServiceQueryService sygServiceQueryService;

    public SygServiceResource(SygServiceService sygServiceService, SygServiceQueryService sygServiceQueryService) {
        this.sygServiceService = sygServiceService;
        this.sygServiceQueryService = sygServiceQueryService;
    }

    /**
     * {@code POST  /syg-services} : Create a new sygService.
     *
     * @param sygServiceDTO the sygServiceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sygServiceDTO, or with status {@code 400 (Bad Request)} if the sygService has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/syg-services")
    public ResponseEntity<SygServiceDTO> createSygService(@Valid @RequestBody SygServiceDTO sygServiceDTO) throws URISyntaxException {
        log.debug("REST request to save SygService : {}", sygServiceDTO);
        if (sygServiceDTO.getId() != null) {
            throw new BadRequestAlertException("A new sygService cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SygServiceDTO result = sygServiceService.save(sygServiceDTO);
        return ResponseEntity.created(new URI("/api/syg-services/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /syg-services} : Updates an existing sygService.
     *
     * @param sygServiceDTO the sygServiceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sygServiceDTO,
     * or with status {@code 400 (Bad Request)} if the sygServiceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sygServiceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/syg-services")
    public ResponseEntity<SygServiceDTO> updateSygService(@Valid @RequestBody SygServiceDTO sygServiceDTO) throws URISyntaxException {
        log.debug("REST request to update SygService : {}", sygServiceDTO);
        if (sygServiceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SygServiceDTO result = sygServiceService.save(sygServiceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sygServiceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /syg-services} : get all the sygServices.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sygServices in body.
     */
    @GetMapping("/syg-services")
    public ResponseEntity<List<SygServiceDTO>> getAllSygServices(SygServiceCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SygServices by criteria: {}", criteria);
        Page<SygServiceDTO> page = sygServiceQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /syg-services/count} : count all the sygServices.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/syg-services/count")
    public ResponseEntity<Long> countSygServices(SygServiceCriteria criteria) {
        log.debug("REST request to count SygServices by criteria: {}", criteria);
        return ResponseEntity.ok().body(sygServiceQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /syg-services/:id} : get the "id" sygService.
     *
     * @param id the id of the sygServiceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sygServiceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/syg-services/{id}")
    public ResponseEntity<SygServiceDTO> getSygService(@PathVariable Long id) {
        log.debug("REST request to get SygService : {}", id);
        Optional<SygServiceDTO> sygServiceDTO = sygServiceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sygServiceDTO);
    }

    /**
     * {@code DELETE  /syg-services/:id} : delete the "id" sygService.
     *
     * @param id the id of the sygServiceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/syg-services/{id}")
    public ResponseEntity<Void> deleteSygService(@PathVariable Long id) {
        log.debug("REST request to delete SygService : {}", id);
        sygServiceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
