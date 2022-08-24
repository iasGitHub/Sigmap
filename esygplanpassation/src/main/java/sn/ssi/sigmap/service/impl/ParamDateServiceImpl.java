package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.ParamDateService;
import sn.ssi.sigmap.domain.ParamDate;
import sn.ssi.sigmap.repository.ParamDateRepository;
import sn.ssi.sigmap.service.dto.ParamDateDTO;
import sn.ssi.sigmap.service.mapper.ParamDateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ParamDate}.
 */
@Service
@Transactional
public class ParamDateServiceImpl implements ParamDateService {

    private final Logger log = LoggerFactory.getLogger(ParamDateServiceImpl.class);

    private final ParamDateRepository paramDateRepository;

    private final ParamDateMapper paramDateMapper;

    public ParamDateServiceImpl(ParamDateRepository paramDateRepository, ParamDateMapper paramDateMapper) {
        this.paramDateRepository = paramDateRepository;
        this.paramDateMapper = paramDateMapper;
    }

    @Override
    public ParamDateDTO save(ParamDateDTO paramDateDTO) {
        log.debug("Request to save ParamDate : {}", paramDateDTO);
        ParamDate paramDate = paramDateMapper.toEntity(paramDateDTO);
        paramDate = paramDateRepository.save(paramDate);
        return paramDateMapper.toDto(paramDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ParamDateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ParamDates");
        return paramDateRepository.findAll(pageable)
            .map(paramDateMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ParamDateDTO> findOne(Long id) {
        log.debug("Request to get ParamDate : {}", id);
        return paramDateRepository.findById(id)
            .map(paramDateMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ParamDate : {}", id);
        paramDateRepository.deleteById(id);
    }
}
