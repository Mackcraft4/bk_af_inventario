package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.FabActividadDTO;
import com.paramonga.ssff.entities.FabActividad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabActividadMapper extends GenericMapper<FabActividad, FabActividadDTO>{}