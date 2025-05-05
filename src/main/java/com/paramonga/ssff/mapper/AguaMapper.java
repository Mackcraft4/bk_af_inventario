package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.AguaDTO;
import com.paramonga.ssff.entities.FabConPdAgua;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AguaMapper {

    /** Omite la referencia a la cabecera para no requerirla en el DTO **/
    @Mapping(target = "cabecera", ignore = true)
    FabConPdAgua toEntity(AguaDTO dto);

    AguaDTO toDto(FabConPdAgua entity);
}