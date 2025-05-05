package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.FabActividadDTO;
import com.paramonga.ssff.mapper.FabActividadMapper;
import com.paramonga.ssff.repositories.dev.DevFabActividadRepository;
import com.paramonga.ssff.repositories.ing.IngFabActividadRepository;
import com.paramonga.ssff.repositories.prd.PrdFabActividadRepository;
import com.paramonga.ssff.repositories.qas.QasFabActividadRepository;
import com.paramonga.ssff.services.FabActividadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FabActividadServiceImpl implements FabActividadService {

    private final DevFabActividadRepository dev;
    private final QasFabActividadRepository qas;
    private final PrdFabActividadRepository prd;
    private final IngFabActividadRepository ing;

    private final FabActividadMapper mapper;

    public FabActividadServiceImpl(DevFabActividadRepository dev, QasFabActividadRepository qas, PrdFabActividadRepository prd, IngFabActividadRepository ing, FabActividadMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<FabActividadDTO> findByEstado(String env, Integer estado) {
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
