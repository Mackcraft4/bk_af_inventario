package com.paramonga.ssff.mapper;

import com.paramonga.ssff.dto.ProgramacionDTO;
import com.paramonga.ssff.entities.Programacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramacionMapper extends GenericMapper<Programacion, ProgramacionDTO> {}
