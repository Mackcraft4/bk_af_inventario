package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.FabRecipienteDTO;
import com.paramonga.ssff.entities.FabRecipiente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabRecipienteMapper extends GenericMapper<FabRecipiente, FabRecipienteDTO>{}