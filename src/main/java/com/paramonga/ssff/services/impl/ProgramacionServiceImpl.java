package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.dto.ProgramacionDTO;
import com.paramonga.ssff.mapper.ProgramacionMapper;
import com.paramonga.ssff.repositories.dev.DevProgramacionRepository;
import com.paramonga.ssff.repositories.ing.IngProgramacionRepository;
import com.paramonga.ssff.repositories.prd.PrdProgramacionRepository;
import com.paramonga.ssff.repositories.qas.QasProgramacionRepository;
import com.paramonga.ssff.services.ProgramacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProgramacionServiceImpl implements ProgramacionService {

    private final DevProgramacionRepository dev;
    private final QasProgramacionRepository qas;
    private final PrdProgramacionRepository prd;
    private final IngProgramacionRepository ing;
    private final ProgramacionMapper mapper;

    public ProgramacionServiceImpl(DevProgramacionRepository dev, QasProgramacionRepository qas, PrdProgramacionRepository prd, IngProgramacionRepository ing, ProgramacionMapper mapper) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
        this.mapper = mapper;
    }

    @Override
    public List<ProgramacionDTO> listarPendientesPorDocumento(String env, String nroDoc) {
        switch (env) {
            case "dev":
                return mapper.toListDto(dev.findByNroDoc(nroDoc));
            case "qas":
                return mapper.toListDto(qas.findByNroDoc(nroDoc));
            case "ing":
                return mapper.toListDto(ing.findByNroDoc(nroDoc));
            case "prd":
                return mapper.toListDto(prd.findByNroDoc(nroDoc));
            default:
                throw new IllegalArgumentException("El entorno '" + env + "' no es válido.");
        }
    }
}
