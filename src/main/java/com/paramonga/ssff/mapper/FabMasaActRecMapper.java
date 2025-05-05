package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.FabMasaActRecDTO;
import com.paramonga.ssff.entities.FabMasaActRec;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabMasaActRecMapper extends GenericMapper<FabMasaActRec, FabMasaActRecDTO>{}