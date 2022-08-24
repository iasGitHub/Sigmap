package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.SygTypeMarcheDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SygTypeMarche} and its DTO {@link SygTypeMarcheDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SygTypeMarcheMapper extends EntityMapper<SygTypeMarcheDTO, SygTypeMarche> {



    default SygTypeMarche fromId(Long id) {
        if (id == null) {
            return null;
        }
        SygTypeMarche sygTypeMarche = new SygTypeMarche();
        sygTypeMarche.setId(id);
        return sygTypeMarche;
    }
}
