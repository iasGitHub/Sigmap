package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.HistoriqueDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Historique} and its DTO {@link HistoriqueDTO}.
 */
@Mapper(componentModel = "spring", uses = {PlanPassationMapper.class})
public interface HistoriqueMapper extends EntityMapper<HistoriqueDTO, Historique> {

    @Mapping(source = "planPassation.id", target = "planPassationId")
    HistoriqueDTO toDto(Historique historique);

    @Mapping(source = "planPassationId", target = "planPassation")
    Historique toEntity(HistoriqueDTO historiqueDTO);

    default Historique fromId(Long id) {
        if (id == null) {
            return null;
        }
        Historique historique = new Historique();
        historique.setId(id);
        return historique;
    }
}
