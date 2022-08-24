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

import sn.ssi.sigmap.domain.SygSourceFinancement;
import sn.ssi.sigmap.domain.*; // for static metamodels
import sn.ssi.sigmap.repository.SygSourceFinancementRepository;
import sn.ssi.sigmap.service.dto.SygSourceFinancementCriteria;
import sn.ssi.sigmap.service.dto.SygSourceFinancementDTO;
import sn.ssi.sigmap.service.mapper.SygSourceFinancementMapper;

/**
 * Service for executing complex queries for {@link SygSourceFinancement} entities in the database.
 * The main input is a {@link SygSourceFinancementCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SygSourceFinancementDTO} or a {@link Page} of {@link SygSourceFinancementDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SygSourceFinancementQueryService extends QueryService<SygSourceFinancement> {

    private final Logger log = LoggerFactory.getLogger(SygSourceFinancementQueryService.class);

    private final SygSourceFinancementRepository sygSourceFinancementRepository;

    private final SygSourceFinancementMapper sygSourceFinancementMapper;

    public SygSourceFinancementQueryService(SygSourceFinancementRepository sygSourceFinancementRepository, SygSourceFinancementMapper sygSourceFinancementMapper) {
        this.sygSourceFinancementRepository = sygSourceFinancementRepository;
        this.sygSourceFinancementMapper = sygSourceFinancementMapper;
    }

    /**
     * Return a {@link List} of {@link SygSourceFinancementDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SygSourceFinancementDTO> findByCriteria(SygSourceFinancementCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SygSourceFinancement> specification = createSpecification(criteria);
        return sygSourceFinancementMapper.toDto(sygSourceFinancementRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SygSourceFinancementDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SygSourceFinancementDTO> findByCriteria(SygSourceFinancementCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SygSourceFinancement> specification = createSpecification(criteria);
        return sygSourceFinancementRepository.findAll(specification, page)
            .map(sygSourceFinancementMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SygSourceFinancementCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SygSourceFinancement> specification = createSpecification(criteria);
        return sygSourceFinancementRepository.count(specification);
    }

    /**
     * Function to convert {@link SygSourceFinancementCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SygSourceFinancement> createSpecification(SygSourceFinancementCriteria criteria) {
        Specification<SygSourceFinancement> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SygSourceFinancement_.id));
            }
            if (criteria.getLibelle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLibelle(), SygSourceFinancement_.libelle));
            }
            if (criteria.getSygTypeSourceFinancementId() != null) {
                specification = specification.and(buildSpecification(criteria.getSygTypeSourceFinancementId(),
                    root -> root.join(SygSourceFinancement_.sygTypeSourceFinancement, JoinType.LEFT).get(SygTypeSourceFinancement_.id)));
            }
        }
        return specification;
    }
}
