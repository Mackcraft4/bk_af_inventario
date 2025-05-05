package com.paramonga.ssff.services;

import com.paramonga.ssff.dto.ParteDiarioDTO;

public interface ParteDiarioService {
    ParteDiarioDTO enviarParteDiario(String env, ParteDiarioDTO dto);
}