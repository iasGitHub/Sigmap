package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.ParamDateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ParamDate} and its DTO {@link ParamDateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ParamDateMapper extends EntityMapper<ParamDateDTO, ParamDate> {



    default ParamDate fromId(Long id) {
        if (id == null) {
            return null;
        }
        ParamDate paramDate = new ParamDate();
        paramDate.setId(id);
        return paramDate;
    }
}
