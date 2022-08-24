package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.SygSourceFinancementDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SygSourceFinancement} and its DTO {@link SygSourceFinancementDTO}.
 */
@Mapper(componentModel = "spring", uses = {SygTypeSourceFinancementMapper.class})
public interface SygSourceFinancementMapper extends EntityMapper<SygSourceFinancementDTO, SygSourceFinancement> {

    @Mapping(source = "sygTypeSourceFinancement.id", target = "sygTypeSourceFinancementId")
    @Mapping(source = "sygTypeSourceFinancement.libelle", target = "sygTypeSourceFinancementLibelle")
    SygSourceFinancementDTO toDto(SygSourceFinancement sygSourceFinancement);

    @Mapping(source = "sygTypeSourceFinancementId", target = "sygTypeSourceFinancement")
    SygSourceFinancement toEntity(SygSourceFinancementDTO sygSourceFinancementDTO);

    default SygSourceFinancement fromId(Long id) {
        if (id == null) {
            return null;
        }
        SygSourceFinancement sygSourceFinancement = new SygSourceFinancement();
        sygSourceFinancement.setId(id);
        return sygSourceFinancement;
    }
}
