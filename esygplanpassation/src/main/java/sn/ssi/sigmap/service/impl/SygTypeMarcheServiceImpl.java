package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.SygTypeMarcheService;
import sn.ssi.sigmap.domain.SygTypeMarche;
import sn.ssi.sigmap.repository.SygTypeMarcheRepository;
import sn.ssi.sigmap.service.dto.SygTypeMarcheDTO;
import sn.ssi.sigmap.service.mapper.SygTypeMarcheMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SygTypeMarche}.
 */
@Service
@Transactional
public class SygTypeMarcheServiceImpl implements SygTypeMarcheService {

    private final Logger log = LoggerFactory.getLogger(SygTypeMarcheServiceImpl.class);

    private final SygTypeMarcheRepository sygTypeMarcheRepository;

    private final SygTypeMarcheMapper sygTypeMarcheMapper;

    public SygTypeMarcheServiceImpl(SygTypeMarcheRepository sygTypeMarcheRepository, SygTypeMarcheMapper sygTypeMarcheMapper) {
        this.sygTypeMarcheRepository = sygTypeMarcheRepository;
        this.sygTypeMarcheMapper = sygTypeMarcheMapper;
    }

    @Override
    public SygTypeMarcheDTO save(SygTypeMarcheDTO sygTypeMarcheDTO) {
        log.debug("Request to save SygTypeMarche : {}", sygTypeMarcheDTO);
        SygTypeMarche sygTypeMarche = sygTypeMarcheMapper.toEntity(sygTypeMarcheDTO);
        sygTypeMarche = sygTypeMarcheRepository.save(sygTypeMarche);
        return sygTypeMarcheMapper.toDto(sygTypeMarche);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SygTypeMarcheDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SygTypeMarches");
        return sygTypeMarcheRepository.findAll(pageable)
            .map(sygTypeMarcheMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SygTypeMarcheDTO> findOne(Long id) {
        log.debug("Request to get SygTypeMarche : {}", id);
        return sygTypeMarcheRepository.findById(id)
            .map(sygTypeMarcheMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SygTypeMarche : {}", id);
        sygTypeMarcheRepository.deleteById(id);
    }
}
