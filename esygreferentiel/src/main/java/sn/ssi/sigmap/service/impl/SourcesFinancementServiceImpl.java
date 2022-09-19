package sn.ssi.sigmap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ssi.sigmap.domain.SourcesFinancement;
import sn.ssi.sigmap.repository.SourcesFinancementRepository;
import sn.ssi.sigmap.service.SourcesFinancementService;
import sn.ssi.sigmap.service.dto.SourcesFinancementDTO;
import sn.ssi.sigmap.service.mapper.SourcesFinancementMapper;

import java.util.Optional;

@Service
@Transactional
public class SourcesFinancementServiceImpl implements SourcesFinancementService {

    private final Logger log = LoggerFactory.getLogger(SourcesFinancementServiceImpl.class);

    private final SourcesFinancementRepository sourcesFinancementRepository;

    private final SourcesFinancementMapper sourcesFinancementMapper;

    public SourcesFinancementServiceImpl(
        SourcesFinancementRepository sourcesFinancementRepository,
        SourcesFinancementMapper sourcesFinancementMapper
    ) {
        this.sourcesFinancementRepository = sourcesFinancementRepository;
        this.sourcesFinancementMapper = sourcesFinancementMapper;
    }

    @Override
    public SourcesFinancementDTO save(SourcesFinancementDTO sourcesFinancementDTO) {
        log.debug("Request to save SourcesFinancement : {}", sourcesFinancementDTO);
        SourcesFinancement sourcesFinancement = sourcesFinancementMapper.toEntity(sourcesFinancementDTO);
        sourcesFinancement = sourcesFinancementRepository.save(sourcesFinancement);
        return sourcesFinancementMapper.toDto(sourcesFinancement);
    }

    @Override
    public SourcesFinancementDTO update(SourcesFinancementDTO sourcesFinancementDTO) {
        log.debug("Request to save SourcesFinancement : {}", sourcesFinancementDTO);
        SourcesFinancement sourcesFinancement = sourcesFinancementMapper.toEntity(sourcesFinancementDTO);
        sourcesFinancement = sourcesFinancementRepository.save(sourcesFinancement);
        return sourcesFinancementMapper.toDto(sourcesFinancement);
    }

    @Override
    public Optional<SourcesFinancementDTO> partialUpdate(SourcesFinancementDTO sourcesFinancementDTO) {
        log.debug("Request to partially update SourcesFinancement : {}", sourcesFinancementDTO);

        return sourcesFinancementRepository
            .findById(sourcesFinancementDTO.getId())
            .map(existingTypeSourceFinancement -> {
                sourcesFinancementMapper.partialUpdate(existingTypeSourceFinancement, sourcesFinancementDTO);

                return existingTypeSourceFinancement;
            })
            .map(sourcesFinancementRepository::save)
            .map(sourcesFinancementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SourcesFinancementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SourcesFinancements");
        return sourcesFinancementRepository.findAll(pageable).map(sourcesFinancementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SourcesFinancementDTO> findOne(Long id) {
        log.debug("Request to get TypeSourceFinancement : {}", id);
        return sourcesFinancementRepository.findById(id).map(sourcesFinancementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SourceFinancement : {}", id);
        sourcesFinancementRepository.deleteById(id);
    }
}
