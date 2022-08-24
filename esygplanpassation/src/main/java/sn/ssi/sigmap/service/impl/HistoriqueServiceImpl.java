package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.HistoriqueService;
import sn.ssi.sigmap.domain.Historique;
import sn.ssi.sigmap.repository.HistoriqueRepository;
import sn.ssi.sigmap.service.dto.HistoriqueDTO;
import sn.ssi.sigmap.service.mapper.HistoriqueMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Historique}.
 */
@Service
@Transactional
public class HistoriqueServiceImpl implements HistoriqueService {

    private final Logger log = LoggerFactory.getLogger(HistoriqueServiceImpl.class);

    private final HistoriqueRepository historiqueRepository;

    private final HistoriqueMapper historiqueMapper;

    public HistoriqueServiceImpl(HistoriqueRepository historiqueRepository, HistoriqueMapper historiqueMapper) {
        this.historiqueRepository = historiqueRepository;
        this.historiqueMapper = historiqueMapper;
    }

    @Override
    public HistoriqueDTO save(HistoriqueDTO historiqueDTO) {
        log.debug("Request to save Historique : {}", historiqueDTO);
        Historique historique = historiqueMapper.toEntity(historiqueDTO);
        historique = historiqueRepository.save(historique);
        return historiqueMapper.toDto(historique);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<HistoriqueDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Historiques");
        return historiqueRepository.findAll(pageable)
            .map(historiqueMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<HistoriqueDTO> findOne(Long id) {
        log.debug("Request to get Historique : {}", id);
        return historiqueRepository.findById(id)
            .map(historiqueMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Historique : {}", id);
        historiqueRepository.deleteById(id);
    }
}
