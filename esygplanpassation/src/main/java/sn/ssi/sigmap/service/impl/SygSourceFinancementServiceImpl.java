package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.SygSourceFinancementService;
import sn.ssi.sigmap.domain.SygSourceFinancement;
import sn.ssi.sigmap.repository.SygSourceFinancementRepository;
import sn.ssi.sigmap.service.dto.SygSourceFinancementDTO;
import sn.ssi.sigmap.service.mapper.SygSourceFinancementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygSourceFinancement}.
 */
@Service
@Transactional
public class SygSourceFinancementServiceImpl implements SygSourceFinancementService {

    private final Logger log = LoggerFactory.getLogger(SygSourceFinancementServiceImpl.class);

    private final SygSourceFinancementRepository sygSourceFinancementRepository;

    private final SygSourceFinancementMapper sygSourceFinancementMapper;

    public SygSourceFinancementServiceImpl(SygSourceFinancementRepository sygSourceFinancementRepository, SygSourceFinancementMapper sygSourceFinancementMapper) {
        this.sygSourceFinancementRepository = sygSourceFinancementRepository;
        this.sygSourceFinancementMapper = sygSourceFinancementMapper;
    }

    @Override
    public SygSourceFinancementDTO save(SygSourceFinancementDTO sygSourceFinancementDTO) {
        log.debug("Request to save SygSourceFinancement : {}", sygSourceFinancementDTO);
        SygSourceFinancement sygSourceFinancement = sygSourceFinancementMapper.toEntity(sygSourceFinancementDTO);
        sygSourceFinancement = sygSourceFinancementRepository.save(sygSourceFinancement);
        return sygSourceFinancementMapper.toDto(sygSourceFinancement);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SygSourceFinancementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SygSourceFinancements");
        return sygSourceFinancementRepository.findAll(pageable)
            .map(sygSourceFinancementMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SygSourceFinancementDTO> findOne(Long id) {
        log.debug("Request to get SygSourceFinancement : {}", id);
        return sygSourceFinancementRepository.findById(id)
            .map(sygSourceFinancementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SygSourceFinancement : {}", id);
        sygSourceFinancementRepository.deleteById(id);
    }
}
