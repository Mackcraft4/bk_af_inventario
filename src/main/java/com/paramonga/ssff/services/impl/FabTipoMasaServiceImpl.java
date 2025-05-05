package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.FabTipoMasaDTO;
import com.paramonga.ssff.mapper.FabTipoMasaMapper;
import com.paramonga.ssff.repositories.dev.DevFabTipoMasaRepository;
import com.paramonga.ssff.repositories.ing.IngFabTipoMasaRepository;
import com.paramonga.ssff.repositories.prd.PrdFabTipoMasaRepository;
import com.paramonga.ssff.repositories.qas.QasFabTipoMasaRepository;
import com.paramonga.ssff.services.FabTipoMasaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FabTipoMasaServiceImpl implements FabTipoMasaService {

    private final DevFabTipoMasaRepository dev;
    private final QasFabTipoMasaRepository qas;
    private final PrdFabTipoMasaRepository prd;
    private final IngFabTipoMasaRepository ing;

    private final FabTipoMasaMapper mapper;

    public FabTipoMasaServiceImpl(DevFabTipoMasaRepository dev, QasFabTipoMasaRepository qas, PrdFabTipoMasaRepository prd, IngFabTipoMasaRepository ing, FabTipoMasaMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<FabTipoMasaDTO> findByEstado(String env, Integer estado) {
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
