package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.RealisationService;
import sn.ssi.sigmap.domain.Realisation;
import sn.ssi.sigmap.repository.RealisationRepository;
import sn.ssi.sigmap.service.dto.RealisationDTO;
import sn.ssi.sigmap.service.mapper.RealisationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Realisation}.
 */
@Service
@Transactional
public class RealisationServiceImpl implements RealisationService {

    private final Logger log = LoggerFactory.getLogger(RealisationServiceImpl.class);

    private final RealisationRepository realisationRepository;

    private final RealisationMapper realisationMapper;

    public RealisationServiceImpl(RealisationRepository realisationRepository, RealisationMapper realisationMapper) {
        this.realisationRepository = realisationRepository;
        this.realisationMapper = realisationMapper;
    }

    @Override
    public RealisationDTO save(RealisationDTO realisationDTO) {
        log.debug("Request to save Realisation : {}", realisationDTO);
        Realisation realisation = realisationMapper.toEntity(realisationDTO);
        realisation = realisationRepository.save(realisation);
        return realisationMapper.toDto(realisation);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RealisationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Realisations");
        return realisationRepository.findAll(pageable)
            .map(realisationMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<RealisationDTO> findOne(Long id) {
        log.debug("Request to get Realisation : {}", id);
        return realisationRepository.findById(id)
            .map(realisationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Realisation : {}", id);
        realisationRepository.deleteById(id);
    }
}
