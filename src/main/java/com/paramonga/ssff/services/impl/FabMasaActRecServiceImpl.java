package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.FabMasaActRecDTO;
import com.paramonga.ssff.mapper.FabMasaActRecMapper;
import com.paramonga.ssff.repositories.dev.DevFabMasaActRecRepository;
import com.paramonga.ssff.repositories.ing.IngFabMasaActRecRepository;
import com.paramonga.ssff.repositories.prd.PrdFabMasaActRecRepository;
import com.paramonga.ssff.repositories.qas.QasFabMasaActRecRepository;
import com.paramonga.ssff.services.FabMasaActRecService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FabMasaActRecServiceImpl implements FabMasaActRecService {

    private final DevFabMasaActRecRepository dev;
    private final QasFabMasaActRecRepository qas;
    private final PrdFabMasaActRecRepository prd;
    private final IngFabMasaActRecRepository ing;

    private final FabMasaActRecMapper mapper;

    public FabMasaActRecServiceImpl(DevFabMasaActRecRepository dev, QasFabMasaActRecRepository qas, PrdFabMasaActRecRepository prd, IngFabMasaActRecRepository ing, FabMasaActRecMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<FabMasaActRecDTO> findByEstado(String env, Integer estado) {
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
