package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.FabTipoMasaDTO;

import java.util.List;

public interface FabTipoMasaService {
    List<FabTipoMasaDTO> findByEstado(String env, Integer estado);
}
