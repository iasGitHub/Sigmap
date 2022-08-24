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

import sn.ssi.sigmap.domain.SygTypeMarche;
import sn.ssi.sigmap.domain.*; // for static metamodels
import sn.ssi.sigmap.repository.SygTypeMarcheRepository;
import sn.ssi.sigmap.service.dto.SygTypeMarcheCriteria;
import sn.ssi.sigmap.service.dto.SygTypeMarcheDTO;
import sn.ssi.sigmap.service.mapper.SygTypeMarcheMapper;

/**
 * Service for executing complex queries for {@link SygTypeMarche} entities in the database.
 * The main input is a {@link SygTypeMarcheCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SygTypeMarcheDTO} or a {@link Page} of {@link SygTypeMarcheDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SygTypeMarcheQueryService extends QueryService<SygTypeMarche> {

    private final Logger log = LoggerFactory.getLogger(SygTypeMarcheQueryService.class);

    private final SygTypeMarcheRepository sygTypeMarcheRepository;

    private final SygTypeMarcheMapper sygTypeMarcheMapper;

    public SygTypeMarcheQueryService(SygTypeMarcheRepository sygTypeMarcheRepository, SygTypeMarcheMapper sygTypeMarcheMapper) {
        this.sygTypeMarcheRepository = sygTypeMarcheRepository;
        this.sygTypeMarcheMapper = sygTypeMarcheMapper;
    }

    /**
     * Return a {@link List} of {@link SygTypeMarcheDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SygTypeMarcheDTO> findByCriteria(SygTypeMarcheCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SygTypeMarche> specification = createSpecification(criteria);
        return sygTypeMarcheMapper.toDto(sygTypeMarcheRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SygTypeMarcheDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SygTypeMarcheDTO> findByCriteria(SygTypeMarcheCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SygTypeMarche> specification = createSpecification(criteria);
        return sygTypeMarcheRepository.findAll(specification, page)
            .map(sygTypeMarcheMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SygTypeMarcheCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SygTypeMarche> specification = createSpecification(criteria);
        return sygTypeMarcheRepository.count(specification);
    }

    /**
     * Function to convert {@link SygTypeMarcheCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SygTypeMarche> createSpecification(SygTypeMarcheCriteria criteria) {
        Specification<SygTypeMarche> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SygTypeMarche_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), SygTypeMarche_.code));
            }
            if (criteria.getLibelle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLibelle(), SygTypeMarche_.libelle));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), SygTypeMarche_.description));
            }
        }
        return specification;
    }
}
