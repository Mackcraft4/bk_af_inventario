package com.paramonga.ssff.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProgramacionDTO {
    private String codigo;
    private String nroDoc;
    private Integer turno;
    private LocalDate fechaNotificacion;
    private LocalDateTime inicioDatetime;
    private LocalDateTime finDatetime;
}