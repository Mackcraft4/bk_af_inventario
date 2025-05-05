package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.FabMaterialDTO;
import com.paramonga.ssff.entities.FabMaterial;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabMaterialMapper extends GenericMapper<FabMaterial, FabMaterialDTO>{}