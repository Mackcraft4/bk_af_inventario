package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.DetalleDTO;
import com.paramonga.ssff.entities.FabConPdDet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetalleMapper {

    /** Omite la referencia a la cabecera para no requerirla en el DTO **/
    @Mapping(target = "cabecera", ignore = true)
    FabConPdDet toEntity(DetalleDTO dto);

    DetalleDTO toDto(FabConPdDet entity);
}