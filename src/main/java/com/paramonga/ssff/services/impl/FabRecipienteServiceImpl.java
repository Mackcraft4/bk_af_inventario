package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.FabRecipienteDTO;
import com.paramonga.ssff.mapper.FabRecipienteMapper;
import com.paramonga.ssff.repositories.dev.DevFabRecipienteRepository;
import com.paramonga.ssff.repositories.ing.IngFabRecipienteRepository;
import com.paramonga.ssff.repositories.prd.PrdFabRecipienteRepository;
import com.paramonga.ssff.repositories.qas.QasFabRecipienteRepository;
import com.paramonga.ssff.services.FabRecipienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FabRecipienteServiceImpl implements FabRecipienteService {

    private final DevFabRecipienteRepository dev;
    private final QasFabRecipienteRepository qas;
    private final PrdFabRecipienteRepository prd;
    private final IngFabRecipienteRepository ing;

    private final FabRecipienteMapper mapper;

    public FabRecipienteServiceImpl(DevFabRecipienteRepository dev, QasFabRecipienteRepository qas, PrdFabRecipienteRepository prd, IngFabRecipienteRepository ing, FabRecipienteMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<FabRecipienteDTO> findByEstado(String env, Integer estado) {
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
