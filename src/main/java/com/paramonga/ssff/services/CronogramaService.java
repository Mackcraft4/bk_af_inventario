package com.paramonga.ssff.services;

import java.util.List;
import com.paramonga.ssff.dto.CronogramaAppDTO;

public interface CronogramaService {

    List<CronogramaAppDTO> obtenerCronogramaPorUsuario(String idUser);
}