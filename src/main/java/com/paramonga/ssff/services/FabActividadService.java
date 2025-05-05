package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.FabActividadDTO;

import java.util.List;

public interface FabActividadService {
    List<FabActividadDTO> findByEstado(String env, Integer estado);
}
