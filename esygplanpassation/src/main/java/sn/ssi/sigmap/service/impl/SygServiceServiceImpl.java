package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.SygServiceService;
import sn.ssi.sigmap.domain.SygService;
import sn.ssi.sigmap.repository.SygServiceRepository;
import sn.ssi.sigmap.service.dto.SygServiceDTO;
import sn.ssi.sigmap.service.mapper.SygServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygService}.
 */
@Service
@Transactional
public class SygServiceServiceImpl implements SygServiceService {

    private final Logger log = LoggerFactory.getLogger(SygServiceServiceImpl.class);

    private final SygServiceRepository sygServiceRepository;

    private final SygServiceMapper sygServiceMapper;

    public SygServiceServiceImpl(SygServiceRepository sygServiceRepository, SygServiceMapper sygServiceMapper) {
        this.sygServiceRepository = sygServiceRepository;
        this.sygServiceMapper = sygServiceMapper;
    }

    @Override
    public SygServiceDTO save(SygServiceDTO sygServiceDTO) {
        log.debug("Request to save SygService : {}", sygServiceDTO);
        SygService sygService = sygServiceMapper.toEntity(sygServiceDTO);
        sygService = sygServiceRepository.save(sygService);
        return sygServiceMapper.toDto(sygService);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SygServiceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SygServices");
        return sygServiceRepository.findAll(pageable)
            .map(sygServiceMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SygServiceDTO> findOne(Long id) {
        log.debug("Request to get SygService : {}", id);
        return sygServiceRepository.findById(id)
            .map(sygServiceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SygService : {}", id);
        sygServiceRepository.deleteById(id);
    }
}
