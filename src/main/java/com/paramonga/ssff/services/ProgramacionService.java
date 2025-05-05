package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.ProgramacionDTO;

import java.util.List;

public interface ProgramacionService {
    List<ProgramacionDTO> listarPendientesPorDocumento(String env, String nroDoc);
}
