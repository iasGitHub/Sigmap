package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.RealisationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Realisation} and its DTO {@link RealisationDTO}.
 */
@Mapper(componentModel = "spring", uses = {PlanPassationMapper.class})
public interface RealisationMapper extends EntityMapper<RealisationDTO, Realisation> {

    @Mapping(source = "planPassation.id", target = "planPassationId")
    RealisationDTO toDto(Realisation realisation);

    @Mapping(source = "planPassationId", target = "planPassation")
    Realisation toEntity(RealisationDTO realisationDTO);

    default Realisation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Realisation realisation = new Realisation();
        realisation.setId(id);
        return realisation;
    }
}
