package com.paramonga.ssff.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ParteDiarioDTO {
    // Campos de la cabecera
    private LocalDate fechaNotificacion;
    private Integer turno;
    private String maestroAzucarero;
    private String usrCreacion;
    private String estacionCreacion;
    private String supervisor;
    private byte[] firma;

    // Listas de hijos
    private List<DetalleDTO> detalles;
    private List<AguaDTO> aguas;
    private List<NivelDTO> niveles;
    private List<ObservacionDTO> observaciones;
}