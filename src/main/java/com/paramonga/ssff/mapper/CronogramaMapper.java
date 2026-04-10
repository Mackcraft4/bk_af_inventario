package com.paramonga.ssff.mapper;

import org.springframework.stereotype.Component;
import com.paramonga.ssff.dto.CronogramaAppDTO;
import com.paramonga.ssff.entities.AfCronInventarioDt;

@Component
public class CronogramaMapper {
public CronogramaAppDTO toDTO(AfCronInventarioDt e) {

    if (e == null) return null;

    CronogramaAppDTO dto = new CronogramaAppDTO();

    dto.setCenco(e.getIdCab() != null ? e.getIdCab().toString() : "SIN CENCO");
    dto.setStartAt(e.getStartAt());
    dto.setEndAt(e.getEndAt());
    dto.setStatus(e.getStatus() != null ? e.getStatus() : 0);

    return dto;
}
}