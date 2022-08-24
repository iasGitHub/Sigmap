package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.SygTypeSourceFinancementDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SygTypeSourceFinancement} and its DTO {@link SygTypeSourceFinancementDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SygTypeSourceFinancementMapper extends EntityMapper<SygTypeSourceFinancementDTO, SygTypeSourceFinancement> {



    default SygTypeSourceFinancement fromId(Long id) {
        if (id == null) {
            return null;
        }
        SygTypeSourceFinancement sygTypeSourceFinancement = new SygTypeSourceFinancement();
        sygTypeSourceFinancement.setId(id);
        return sygTypeSourceFinancement;
    }
}
