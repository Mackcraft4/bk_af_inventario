package com.paramonga.ssff.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AguaDTO {
    private LocalDateTime fechaNotificacion;
    private Integer nRecipientes;
    private double pSig;
    private Integer flagTipo;
    private String usrCreacion;
    private String estacionCreacion;
}