package com.paramonga.ssff.entities;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Immutable
@Table(name = "vw_fab_con_prg_pend")
public class Programacion {

    @Id
    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "NRO_DOC")
    private String nroDoc;

    @Column(name = "TURNO")
    private Integer turno;

    @Column(name = "FECHA_NOTIFICACION")
    private LocalDate fechaNotificacion;

    @Column(name = "INICIO_DATETIME")
    private LocalDateTime inicioDatetime;

    @Column(name = "FIN_DATETIME")
    private LocalDateTime finDatetime;
}