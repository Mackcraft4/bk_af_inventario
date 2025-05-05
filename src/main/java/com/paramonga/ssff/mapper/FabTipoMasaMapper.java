package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.FabTipoMasaDTO;
import com.paramonga.ssff.entities.FabTipoMasa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabTipoMasaMapper extends GenericMapper<FabTipoMasa, FabTipoMasaDTO>{}