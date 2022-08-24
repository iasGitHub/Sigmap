package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.ParamDateService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.ParamDateDTO;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.ssi.sigmap.domain.ParamDate}.
 */
@RestController
@RequestMapping("/api")
public class ParamDateResource {

    private final Logger log = LoggerFactory.getLogger(ParamDateResource.class);

    private static final String ENTITY_NAME = "planpassationmsParamDate";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ParamDateService paramDateService;

    public ParamDateResource(ParamDateService paramDateService) {
        this.paramDateService = paramDateService;
    }

    /**
     * {@code POST  /param-dates} : Create a new paramDate.
     *
     * @param paramDateDTO the paramDateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paramDateDTO, or with status {@code 400 (Bad Request)} if the paramDate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/param-dates")
    public ResponseEntity<ParamDateDTO> createParamDate(@RequestBody ParamDateDTO paramDateDTO) throws URISyntaxException {
        log.debug("REST request to save ParamDate : {}", paramDateDTO);
        if (paramDateDTO.getId() != null) {
            throw new BadRequestAlertException("A new paramDate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ParamDateDTO result = paramDateService.save(paramDateDTO);
        return ResponseEntity.created(new URI("/api/param-dates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /param-dates} : Updates an existing paramDate.
     *
     * @param paramDateDTO the paramDateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paramDateDTO,
     * or with status {@code 400 (Bad Request)} if the paramDateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paramDateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/param-dates")
    public ResponseEntity<ParamDateDTO> updateParamDate(@RequestBody ParamDateDTO paramDateDTO) throws URISyntaxException {
        log.debug("REST request to update ParamDate : {}", paramDateDTO);
        if (paramDateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ParamDateDTO result = paramDateService.save(paramDateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paramDateDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /param-dates} : get all the paramDates.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paramDates in body.
     */
    @GetMapping("/param-dates")
    public ResponseEntity<List<ParamDateDTO>> getAllParamDates(Pageable pageable) {
        log.debug("REST request to get a page of ParamDates");
        Page<ParamDateDTO> page = paramDateService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /param-dates/:id} : get the "id" paramDate.
     *
     * @param id the id of the paramDateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paramDateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/param-dates/{id}")
    public ResponseEntity<ParamDateDTO> getParamDate(@PathVariable Long id) {
        log.debug("REST request to get ParamDate : {}", id);
        Optional<ParamDateDTO> paramDateDTO = paramDateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paramDateDTO);
    }

    /**
     * {@code DELETE  /param-dates/:id} : delete the "id" paramDate.
     *
     * @param id the id of the paramDateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/param-dates/{id}")
    public ResponseEntity<Void> deleteParamDate(@PathVariable Long id) {
        log.debug("REST request to delete ParamDate : {}", id);
        paramDateService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
