package com.paramonga.ssff.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObservacionDTO {
    private String descripcion;
    private Integer flagTipo;
    private LocalDateTime fechaNotificacion;
    private String usrCreacion;
    private String estacionCreacion;
}