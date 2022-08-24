package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PlanPassationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PlanPassation} and its DTO {@link PlanPassationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PlanPassationMapper extends EntityMapper<PlanPassationDTO, PlanPassation> {



    default PlanPassation fromId(Long id) {
        if (id == null) {
            return null;
        }
        PlanPassation planPassation = new PlanPassation();
        planPassation.setId(id);
        return planPassation;
    }
}
