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

import sn.ssi.sigmap.domain.SygTypeSourceFinancement;
import sn.ssi.sigmap.domain.*; // for static metamodels
import sn.ssi.sigmap.repository.SygTypeSourceFinancementRepository;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementCriteria;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementDTO;
import sn.ssi.sigmap.service.mapper.SygTypeSourceFinancementMapper;

/**
 * Service for executing complex queries for {@link SygTypeSourceFinancement} entities in the database.
 * The main input is a {@link SygTypeSourceFinancementCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SygTypeSourceFinancementDTO} or a {@link Page} of {@link SygTypeSourceFinancementDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SygTypeSourceFinancementQueryService extends QueryService<SygTypeSourceFinancement> {

    private final Logger log = LoggerFactory.getLogger(SygTypeSourceFinancementQueryService.class);

    private final SygTypeSourceFinancementRepository sygTypeSourceFinancementRepository;

    private final SygTypeSourceFinancementMapper sygTypeSourceFinancementMapper;

    public SygTypeSourceFinancementQueryService(SygTypeSourceFinancementRepository sygTypeSourceFinancementRepository, SygTypeSourceFinancementMapper sygTypeSourceFinancementMapper) {
        this.sygTypeSourceFinancementRepository = sygTypeSourceFinancementRepository;
        this.sygTypeSourceFinancementMapper = sygTypeSourceFinancementMapper;
    }

    /**
     * Return a {@link List} of {@link SygTypeSourceFinancementDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SygTypeSourceFinancementDTO> findByCriteria(SygTypeSourceFinancementCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SygTypeSourceFinancement> specification = createSpecification(criteria);
        return sygTypeSourceFinancementMapper.toDto(sygTypeSourceFinancementRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SygTypeSourceFinancementDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SygTypeSourceFinancementDTO> findByCriteria(SygTypeSourceFinancementCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SygTypeSourceFinancement> specification = createSpecification(criteria);
        return sygTypeSourceFinancementRepository.findAll(specification, page)
            .map(sygTypeSourceFinancementMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SygTypeSourceFinancementCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SygTypeSourceFinancement> specification = createSpecification(criteria);
        return sygTypeSourceFinancementRepository.count(specification);
    }

    /**
     * Function to convert {@link SygTypeSourceFinancementCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SygTypeSourceFinancement> createSpecification(SygTypeSourceFinancementCriteria criteria) {
        Specification<SygTypeSourceFinancement> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SygTypeSourceFinancement_.id));
            }
            if (criteria.getLibelle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLibelle(), SygTypeSourceFinancement_.libelle));
            }
        }
        return specification;
    }
}
