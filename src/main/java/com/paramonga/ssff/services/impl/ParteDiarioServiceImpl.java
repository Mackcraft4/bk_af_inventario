package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.ParteDiarioDTO;
import com.paramonga.ssff.entities.FabConPdCab;
import com.paramonga.ssff.mapper.ParteDiarioMapper;
import com.paramonga.ssff.repositories.dev.DevFabConPdCabRepository;
import com.paramonga.ssff.repositories.ing.IngFabConPdCabRepository;
import com.paramonga.ssff.repositories.prd.PrdFabConPdCabRepository;
import com.paramonga.ssff.repositories.qas.QasFabConPdCabRepository;
import com.paramonga.ssff.services.ParteDiarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParteDiarioServiceImpl implements ParteDiarioService {

    private final DevFabConPdCabRepository dev;
    private final QasFabConPdCabRepository qas;
    private final PrdFabConPdCabRepository prd;
    private final IngFabConPdCabRepository ing;
    private final ParteDiarioMapper mapper;

    public ParteDiarioServiceImpl(
            DevFabConPdCabRepository dev,
            QasFabConPdCabRepository qas,
            PrdFabConPdCabRepository prd,
            IngFabConPdCabRepository ing,
            ParteDiarioMapper mapper) {
        this.dev    = dev;
        this.qas    = qas;
        this.prd    = prd;
        this.ing    = ing;
        this.mapper = mapper;
    }

    @Override
    public ParteDiarioDTO enviarParteDiario(String env, ParteDiarioDTO dto) {
        // Mapea DTO → entidad
        FabConPdCab entity = mapper.toEntity(dto);
        // Forzar INSERT sin SELECT previo
        entity.setNew(true);

        // Elige el repositorio según el entorno
        FabConPdCab saved;
        switch (env) {
            case "dev": saved = dev.save(entity); break;
            case "qas": saved = qas.save(entity); break;
            case "prd": saved = prd.save(entity); break;
            case "ing": saved = ing.save(entity); break;
            default:
                throw new IllegalArgumentException("El entorno '" + env + "' no es válido.");
        }

        // Mapea entidad → DTO y devuelve
        return mapper.toDto(saved);
    }
}