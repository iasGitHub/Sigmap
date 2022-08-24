package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.SygTypeSourceFinancementService;
import sn.ssi.sigmap.domain.SygTypeSourceFinancement;
import sn.ssi.sigmap.repository.SygTypeSourceFinancementRepository;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementDTO;
import sn.ssi.sigmap.service.mapper.SygTypeSourceFinancementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygTypeSourceFinancement}.
 */
@Service
@Transactional
public class SygTypeSourceFinancementServiceImpl implements SygTypeSourceFinancementService {

    private final Logger log = LoggerFactory.getLogger(SygTypeSourceFinancementServiceImpl.class);

    private final SygTypeSourceFinancementRepository sygTypeSourceFinancementRepository;

    private final SygTypeSourceFinancementMapper sygTypeSourceFinancementMapper;

    public SygTypeSourceFinancementServiceImpl(SygTypeSourceFinancementRepository sygTypeSourceFinancementRepository, SygTypeSourceFinancementMapper sygTypeSourceFinancementMapper) {
        this.sygTypeSourceFinancementRepository = sygTypeSourceFinancementRepository;
        this.sygTypeSourceFinancementMapper = sygTypeSourceFinancementMapper;
    }

    @Override
    public SygTypeSourceFinancementDTO save(SygTypeSourceFinancementDTO sygTypeSourceFinancementDTO) {
        log.debug("Request to save SygTypeSourceFinancement : {}", sygTypeSourceFinancementDTO);
        SygTypeSourceFinancement sygTypeSourceFinancement = sygTypeSourceFinancementMapper.toEntity(sygTypeSourceFinancementDTO);
        sygTypeSourceFinancement = sygTypeSourceFinancementRepository.save(sygTypeSourceFinancement);
        return sygTypeSourceFinancementMapper.toDto(sygTypeSourceFinancement);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SygTypeSourceFinancementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SygTypeSourceFinancements");
        return sygTypeSourceFinancementRepository.findAll(pageable)
            .map(sygTypeSourceFinancementMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SygTypeSourceFinancementDTO> findOne(Long id) {
        log.debug("Request to get SygTypeSourceFinancement : {}", id);
        return sygTypeSourceFinancementRepository.findById(id)
            .map(sygTypeSourceFinancementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SygTypeSourceFinancement : {}", id);
        sygTypeSourceFinancementRepository.deleteById(id);
    }
}
