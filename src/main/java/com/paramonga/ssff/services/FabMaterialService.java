package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.FabMaterialDTO;

import java.util.List;

public interface FabMaterialService {
    List<FabMaterialDTO> findByEstado(String env, Integer estado);
}
