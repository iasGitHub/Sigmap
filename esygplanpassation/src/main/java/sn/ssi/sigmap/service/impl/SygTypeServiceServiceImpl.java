package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.SygTypeServiceService;
import sn.ssi.sigmap.domain.SygTypeService;
import sn.ssi.sigmap.repository.SygTypeServiceRepository;
import sn.ssi.sigmap.service.dto.SygTypeServiceDTO;
import sn.ssi.sigmap.service.mapper.SygTypeServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygTypeService}.
 */
@Service
@Transactional
public class SygTypeServiceServiceImpl implements SygTypeServiceService {

    private final Logger log = LoggerFactory.getLogger(SygTypeServiceServiceImpl.class);

    private final SygTypeServiceRepository sygTypeServiceRepository;

    private final SygTypeServiceMapper sygTypeServiceMapper;

    public SygTypeServiceServiceImpl(SygTypeServiceRepository sygTypeServiceRepository, SygTypeServiceMapper sygTypeServiceMapper) {
        this.sygTypeServiceRepository = sygTypeServiceRepository;
        this.sygTypeServiceMapper = sygTypeServiceMapper;
    }

    @Override
    public SygTypeServiceDTO save(SygTypeServiceDTO sygTypeServiceDTO) {
        log.debug("Request to save SygTypeService : {}", sygTypeServiceDTO);
        SygTypeService sygTypeService = sygTypeServiceMapper.toEntity(sygTypeServiceDTO);
        sygTypeService = sygTypeServiceRepository.save(sygTypeService);
        return sygTypeServiceMapper.toDto(sygTypeService);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SygTypeServiceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SygTypeServices");
        return sygTypeServiceRepository.findAll(pageable)
            .map(sygTypeServiceMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SygTypeServiceDTO> findOne(Long id) {
        log.debug("Request to get SygTypeService : {}", id);
        return sygTypeServiceRepository.findById(id)
            .map(sygTypeServiceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SygTypeService : {}", id);
        sygTypeServiceRepository.deleteById(id);
    }
}
