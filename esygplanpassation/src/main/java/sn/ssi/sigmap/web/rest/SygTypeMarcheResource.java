package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.SygTypeMarcheService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.SygTypeMarcheDTO;
import sn.ssi.sigmap.service.dto.SygTypeMarcheCriteria;
import sn.ssi.sigmap.service.SygTypeMarcheQueryService;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.SygTypeMarche}.
 */
@RestController
@RequestMapping("/api")
public class SygTypeMarcheResource {

    private final Logger log = LoggerFactory.getLogger(SygTypeMarcheResource.class);

    private static final String ENTITY_NAME = "planpassationmsSygTypeMarche";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SygTypeMarcheService sygTypeMarcheService;

    private final SygTypeMarcheQueryService sygTypeMarcheQueryService;

    public SygTypeMarcheResource(SygTypeMarcheService sygTypeMarcheService, SygTypeMarcheQueryService sygTypeMarcheQueryService) {
        this.sygTypeMarcheService = sygTypeMarcheService;
        this.sygTypeMarcheQueryService = sygTypeMarcheQueryService;
    }

    /**
     * {@code POST  /syg-type-marches} : Create a new sygTypeMarche.
     *
     * @param sygTypeMarcheDTO the sygTypeMarcheDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sygTypeMarcheDTO, or with status {@code 400 (Bad Request)} if the sygTypeMarche has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/syg-type-marches")
    public ResponseEntity<SygTypeMarcheDTO> createSygTypeMarche(@Valid @RequestBody SygTypeMarcheDTO sygTypeMarcheDTO) throws URISyntaxException {
        log.debug("REST request to save SygTypeMarche : {}", sygTypeMarcheDTO);
        if (sygTypeMarcheDTO.getId() != null) {
            throw new BadRequestAlertException("A new sygTypeMarche cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SygTypeMarcheDTO result = sygTypeMarcheService.save(sygTypeMarcheDTO);
        return ResponseEntity.created(new URI("/api/syg-type-marches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /syg-type-marches} : Updates an existing sygTypeMarche.
     *
     * @param sygTypeMarcheDTO the sygTypeMarcheDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sygTypeMarcheDTO,
     * or with status {@code 400 (Bad Request)} if the sygTypeMarcheDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sygTypeMarcheDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/syg-type-marches")
    public ResponseEntity<SygTypeMarcheDTO> updateSygTypeMarche(@Valid @RequestBody SygTypeMarcheDTO sygTypeMarcheDTO) throws URISyntaxException {
        log.debug("REST request to update SygTypeMarche : {}", sygTypeMarcheDTO);
        if (sygTypeMarcheDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SygTypeMarcheDTO result = sygTypeMarcheService.save(sygTypeMarcheDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sygTypeMarcheDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /syg-type-marches} : get all the sygTypeMarches.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sygTypeMarches in body.
     */
    @GetMapping("/syg-type-marches")
    public ResponseEntity<List<SygTypeMarcheDTO>> getAllSygTypeMarches(SygTypeMarcheCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SygTypeMarches by criteria: {}", criteria);
        Page<SygTypeMarcheDTO> page = sygTypeMarcheQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /syg-type-marches/count} : count all the sygTypeMarches.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/syg-type-marches/count")
    public ResponseEntity<Long> countSygTypeMarches(SygTypeMarcheCriteria criteria) {
        log.debug("REST request to count SygTypeMarches by criteria: {}", criteria);
        return ResponseEntity.ok().body(sygTypeMarcheQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /syg-type-marches/:id} : get the "id" sygTypeMarche.
     *
     * @param id the id of the sygTypeMarcheDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sygTypeMarcheDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/syg-type-marches/{id}")
    public ResponseEntity<SygTypeMarcheDTO> getSygTypeMarche(@PathVariable Long id) {
        log.debug("REST request to get SygTypeMarche : {}", id);
        Optional<SygTypeMarcheDTO> sygTypeMarcheDTO = sygTypeMarcheService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sygTypeMarcheDTO);
    }

    /**
     * {@code DELETE  /syg-type-marches/:id} : delete the "id" sygTypeMarche.
     *
     * @param id the id of the sygTypeMarcheDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/syg-type-marches/{id}")
    public ResponseEntity<Void> deleteSygTypeMarche(@PathVariable Long id) {
        log.debug("REST request to delete SygTypeMarche : {}", id);
        sygTypeMarcheService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
