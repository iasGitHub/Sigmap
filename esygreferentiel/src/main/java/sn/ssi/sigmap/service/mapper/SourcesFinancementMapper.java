package sn.ssi.sigmap.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.ssi.sigmap.domain.SourcesFinancement;
import sn.ssi.sigmap.service.dto.SourcesFinancementDTO;

@Mapper(componentModel = "spring")
public interface SourcesFinancementMapper extends EntityMapper<SourcesFinancementDTO, SourcesFinancement>{

    SourcesFinancementDTO toDto(SourcesFinancement s);

}
