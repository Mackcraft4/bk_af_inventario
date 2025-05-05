package com.paramonga.ssff.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetalleDTO {
    private LocalDateTime fechaNotificacion;
    private Integer tipoMasa;
    private Integer actividad;
    private Integer recipiente;
    private Integer cristalizador;
    private Integer templa;
    private String usrCreacion;
    private String estacionCreacion;
}