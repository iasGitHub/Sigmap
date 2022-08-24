package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.SygTypeServiceService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.SygTypeServiceDTO;
import sn.ssi.sigmap.service.dto.SygTypeServiceCriteria;
import sn.ssi.sigmap.service.SygTypeServiceQueryService;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.SygTypeService}.
 */
@RestController
@RequestMapping("/api")
public class SygTypeServiceResource {

    private final Logger log = LoggerFactory.getLogger(SygTypeServiceResource.class);

    private static final String ENTITY_NAME = "planpassationmsSygTypeService";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SygTypeServiceService sygTypeServiceService;

    private final SygTypeServiceQueryService sygTypeServiceQueryService;

    public SygTypeServiceResource(SygTypeServiceService sygTypeServiceService, SygTypeServiceQueryService sygTypeServiceQueryService) {
        this.sygTypeServiceService = sygTypeServiceService;
        this.sygTypeServiceQueryService = sygTypeServiceQueryService;
    }

    /**
     * {@code POST  /syg-type-services} : Create a new sygTypeService.
     *
     * @param sygTypeServiceDTO the sygTypeServiceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sygTypeServiceDTO, or with status {@code 400 (Bad Request)} if the sygTypeService has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/syg-type-services")
    public ResponseEntity<SygTypeServiceDTO> createSygTypeService(@Valid @RequestBody SygTypeServiceDTO sygTypeServiceDTO) throws URISyntaxException {
        log.debug("REST request to save SygTypeService : {}", sygTypeServiceDTO);
        if (sygTypeServiceDTO.getId() != null) {
            throw new BadRequestAlertException("A new sygTypeService cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SygTypeServiceDTO result = sygTypeServiceService.save(sygTypeServiceDTO);
        return ResponseEntity.created(new URI("/api/syg-type-services/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /syg-type-services} : Updates an existing sygTypeService.
     *
     * @param sygTypeServiceDTO the sygTypeServiceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sygTypeServiceDTO,
     * or with status {@code 400 (Bad Request)} if the sygTypeServiceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sygTypeServiceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/syg-type-services")
    public ResponseEntity<SygTypeServiceDTO> updateSygTypeService(@Valid @RequestBody SygTypeServiceDTO sygTypeServiceDTO) throws URISyntaxException {
        log.debug("REST request to update SygTypeService : {}", sygTypeServiceDTO);
        if (sygTypeServiceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SygTypeServiceDTO result = sygTypeServiceService.save(sygTypeServiceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sygTypeServiceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /syg-type-services} : get all the sygTypeServices.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sygTypeServices in body.
     */
    @GetMapping("/syg-type-services")
    public ResponseEntity<List<SygTypeServiceDTO>> getAllSygTypeServices(SygTypeServiceCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SygTypeServices by criteria: {}", criteria);
        Page<SygTypeServiceDTO> page = sygTypeServiceQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /syg-type-services/count} : count all the sygTypeServices.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/syg-type-services/count")
    public ResponseEntity<Long> countSygTypeServices(SygTypeServiceCriteria criteria) {
        log.debug("REST request to count SygTypeServices by criteria: {}", criteria);
        return ResponseEntity.ok().body(sygTypeServiceQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /syg-type-services/:id} : get the "id" sygTypeService.
     *
     * @param id the id of the sygTypeServiceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sygTypeServiceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/syg-type-services/{id}")
    public ResponseEntity<SygTypeServiceDTO> getSygTypeService(@PathVariable Long id) {
        log.debug("REST request to get SygTypeService : {}", id);
        Optional<SygTypeServiceDTO> sygTypeServiceDTO = sygTypeServiceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sygTypeServiceDTO);
    }

    /**
     * {@code DELETE  /syg-type-services/:id} : delete the "id" sygTypeService.
     *
     * @param id the id of the sygTypeServiceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/syg-type-services/{id}")
    public ResponseEntity<Void> deleteSygTypeService(@PathVariable Long id) {
        log.debug("REST request to delete SygTypeService : {}", id);
        sygTypeServiceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
