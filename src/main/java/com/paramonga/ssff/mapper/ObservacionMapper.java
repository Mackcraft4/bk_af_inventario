package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.ObservacionDTO;
import com.paramonga.ssff.entities.FabConPdObs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ObservacionMapper {

    /** Omite la referencia a la cabecera para no requerirla en el DTO **/
    @Mapping(target = "cabecera", ignore = true)
    FabConPdObs toEntity(ObservacionDTO dto);

    ObservacionDTO toDto(FabConPdObs entity);
}