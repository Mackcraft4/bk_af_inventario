package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.ParteDiarioDTO;
import com.paramonga.ssff.entities.FabConPdCab;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {DetalleMapper.class, AguaMapper.class, NivelMapper.class, ObservacionMapper.class})
public interface ParteDiarioMapper {
    ParteDiarioDTO toDto(FabConPdCab entity);
    FabConPdCab toEntity(ParteDiarioDTO dto);

    @AfterMapping
    default void linkChildren(@MappingTarget FabConPdCab cab,
                              ParteDiarioDTO dto) {
        cab.getDetalles()       .forEach(d -> d.setCabecera(cab));
        cab.getAguas()          .forEach(a -> a.setCabecera(cab));
        cab.getNiveles()        .forEach(n -> n.setCabecera(cab));
        cab.getObservaciones()  .forEach(o -> o.setCabecera(cab));
    }
}