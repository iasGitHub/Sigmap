package sn.ssi.sigmap.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import sn.ssi.sigmap.domain.SygTypeService;
import sn.ssi.sigmap.domain.*; // for static metamodels
import sn.ssi.sigmap.repository.SygTypeServiceRepository;
import sn.ssi.sigmap.service.dto.SygTypeServiceCriteria;
import sn.ssi.sigmap.service.dto.SygTypeServiceDTO;
import sn.ssi.sigmap.service.mapper.SygTypeServiceMapper;

/**
 * Service for executing complex queries for {@link SygTypeService} entities in the database.
 * The main input is a {@link SygTypeServiceCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SygTypeServiceDTO} or a {@link Page} of {@link SygTypeServiceDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SygTypeServiceQueryService extends QueryService<SygTypeService> {

    private final Logger log = LoggerFactory.getLogger(SygTypeServiceQueryService.class);

    private final SygTypeServiceRepository sygTypeServiceRepository;

    private final SygTypeServiceMapper sygTypeServiceMapper;

    public SygTypeServiceQueryService(SygTypeServiceRepository sygTypeServiceRepository, SygTypeServiceMapper sygTypeServiceMapper) {
        this.sygTypeServiceRepository = sygTypeServiceRepository;
        this.sygTypeServiceMapper = sygTypeServiceMapper;
    }

    /**
     * Return a {@link List} of {@link SygTypeServiceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SygTypeServiceDTO> findByCriteria(SygTypeServiceCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SygTypeService> specification = createSpecification(criteria);
        return sygTypeServiceMapper.toDto(sygTypeServiceRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SygTypeServiceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SygTypeServiceDTO> findByCriteria(SygTypeServiceCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SygTypeService> specification = createSpecification(criteria);
        return sygTypeServiceRepository.findAll(specification, page)
            .map(sygTypeServiceMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SygTypeServiceCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SygTypeService> specification = createSpecification(criteria);
        return sygTypeServiceRepository.count(specification);
    }

    /**
     * Function to convert {@link SygTypeServiceCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SygTypeService> createSpecification(SygTypeServiceCriteria criteria) {
        Specification<SygTypeService> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SygTypeService_.id));
            }
            if (criteria.getLibelle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLibelle(), SygTypeService_.libelle));
            }
        }
        return specification;
    }
}
