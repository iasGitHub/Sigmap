package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.SygServiceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SygService} and its DTO {@link SygServiceDTO}.
 */
@Mapper(componentModel = "spring", uses = {SygTypeServiceMapper.class})
public interface SygServiceMapper extends EntityMapper<SygServiceDTO, SygService> {

    @Mapping(source = "sygTypeService.id", target = "sygTypeServiceId")
    @Mapping(source = "sygTypeService.libelle", target = "sygTypeServiceLibelle")
    SygServiceDTO toDto(SygService sygService);

    @Mapping(source = "sygTypeServiceId", target = "sygTypeService")
    SygService toEntity(SygServiceDTO sygServiceDTO);

    default SygService fromId(Long id) {
        if (id == null) {
            return null;
        }
        SygService sygService = new SygService();
        sygService.setId(id);
        return sygService;
    }
}
