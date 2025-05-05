package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.FabRecipienteDTO;

import java.util.List;

public interface FabRecipienteService {
    List<FabRecipienteDTO> findByEstado(String env, Integer estado);
}
