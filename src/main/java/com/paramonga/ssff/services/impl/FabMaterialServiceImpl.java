package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.FabMaterialDTO;
import com.paramonga.ssff.mapper.FabMaterialMapper;
import com.paramonga.ssff.repositories.dev.DevFabMaterialRepository;
import com.paramonga.ssff.repositories.ing.IngFabMaterialRepository;
import com.paramonga.ssff.repositories.prd.PrdFabMaterialRepository;
import com.paramonga.ssff.repositories.qas.QasFabMaterialRepository;
import com.paramonga.ssff.services.FabMaterialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FabMaterialServiceImpl implements FabMaterialService {

    private final DevFabMaterialRepository dev;
    private final QasFabMaterialRepository qas;
    private final PrdFabMaterialRepository prd;
    private final IngFabMaterialRepository ing;

    private final FabMaterialMapper mapper;

    public FabMaterialServiceImpl(DevFabMaterialRepository dev, QasFabMaterialRepository qas, PrdFabMaterialRepository prd, IngFabMaterialRepository ing, FabMaterialMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<FabMaterialDTO> findByEstado(String env, Integer estado) {
        switch (env) {
            case "dev":
                return mapper.toListDto(dev.findByEstado(estado));
            case "qas":
                return mapper.toListDto(qas.findByEstado(estado));
            case "prd":
                return mapper.toListDto(prd.findByEstado(estado));
            case "ing":
                return mapper.toListDto(ing.findByEstado(estado));
            default:
                throw new IllegalArgumentException("El entorno '" + env + "' no es válido.");
        }
    }
}
