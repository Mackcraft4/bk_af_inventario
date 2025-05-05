package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.NivelDTO;
import com.paramonga.ssff.entities.FabConPdNivel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NivelMapper {

    /** Omite la referencia a la cabecera para no requerirla en el DTO **/
    @Mapping(target = "cabecera", ignore = true)
    FabConPdNivel toEntity(NivelDTO dto);

    NivelDTO toDto(FabConPdNivel entity);
}