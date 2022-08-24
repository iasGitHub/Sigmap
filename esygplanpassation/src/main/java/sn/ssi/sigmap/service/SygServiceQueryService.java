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

import sn.ssi.sigmap.domain.SygService;
import sn.ssi.sigmap.domain.*; // for static metamodels
import sn.ssi.sigmap.repository.SygServiceRepository;
import sn.ssi.sigmap.service.dto.SygServiceCriteria;
import sn.ssi.sigmap.service.dto.SygServiceDTO;
import sn.ssi.sigmap.service.mapper.SygServiceMapper;

/**
 * Service for executing complex queries for {@link SygService} entities in the database.
 * The main input is a {@link SygServiceCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SygServiceDTO} or a {@link Page} of {@link SygServiceDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SygServiceQueryService extends QueryService<SygService> {

    private final Logger log = LoggerFactory.getLogger(SygServiceQueryService.class);

    private final SygServiceRepository sygServiceRepository;

    private final SygServiceMapper sygServiceMapper;

    public SygServiceQueryService(SygServiceRepository sygServiceRepository, SygServiceMapper sygServiceMapper) {
        this.sygServiceRepository = sygServiceRepository;
        this.sygServiceMapper = sygServiceMapper;
    }

    /**
     * Return a {@link List} of {@link SygServiceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SygServiceDTO> findByCriteria(SygServiceCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SygService> specification = createSpecification(criteria);
        return sygServiceMapper.toDto(sygServiceRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SygServiceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SygServiceDTO> findByCriteria(SygServiceCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SygService> specification = createSpecification(criteria);
        return sygServiceRepository.findAll(specification, page)
            .map(sygServiceMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SygServiceCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SygService> specification = createSpecification(criteria);
        return sygServiceRepository.count(specification);
    }

    /**
     * Function to convert {@link SygServiceCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SygService> createSpecification(SygServiceCriteria criteria) {
        Specification<SygService> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SygService_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), SygService_.code));
            }
            if (criteria.getLibelle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLibelle(), SygService_.libelle));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), SygService_.description));
            }
            if (criteria.getSygTypeServiceId() != null) {
                specification = specification.and(buildSpecification(criteria.getSygTypeServiceId(),
                    root -> root.join(SygService_.sygTypeService, JoinType.LEFT).get(SygTypeService_.id)));
            }
        }
        return specification;
    }
}
