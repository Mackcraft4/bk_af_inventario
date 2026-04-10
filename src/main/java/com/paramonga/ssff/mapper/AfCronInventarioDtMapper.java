package com.paramonga.ssff.mapper;

import org.springframework.stereotype.Component;
import com.paramonga.ssff.dto.AfCronInventarioDtDTO;
import com.paramonga.ssff.entities.AfCronInventarioDt;

@Component
public class AfCronInventarioDtMapper {

    // ✔ ENTITY → DTO
    public AfCronInventarioDtDTO toDTO(AfCronInventarioDt e) {

        AfCronInventarioDtDTO dto = new AfCronInventarioDtDTO();

        dto.setIdCron(e.getIdCron());
        dto.setIdCab(e.getIdCab());
        dto.setIdUser(e.getIdUser());
        dto.setStatus(e.getStatus());
        dto.setStartAt(e.getStartAt());
        dto.setEndAt(e.getEndAt());

        return dto;
    }

    // ✔ DTO → ENTITY (ESTO TE FALTABA)
    public AfCronInventarioDt toEntity(AfCronInventarioDtDTO dto) {

        AfCronInventarioDt e = new AfCronInventarioDt();

        e.setIdCron(dto.getIdCron());
        e.setIdCab(dto.getIdCab());
        e.setIdUser(dto.getIdUser());
        e.setStatus(dto.getStatus());
        e.setStartAt(dto.getStartAt());
        e.setEndAt(dto.getEndAt());

        return e;
    }
}