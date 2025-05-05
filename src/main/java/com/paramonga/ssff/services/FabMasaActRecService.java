package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.FabMasaActRecDTO;

import java.util.List;

public interface FabMasaActRecService {
    List<FabMasaActRecDTO> findByEstado(String env, Integer estado);
}
