package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.SygTypeServiceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SygTypeService} and its DTO {@link SygTypeServiceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SygTypeServiceMapper extends EntityMapper<SygTypeServiceDTO, SygTypeService> {



    default SygTypeService fromId(Long id) {
        if (id == null) {
            return null;
        }
        SygTypeService sygTypeService = new SygTypeService();
        sygTypeService.setId(id);
        return sygTypeService;
    }
}
