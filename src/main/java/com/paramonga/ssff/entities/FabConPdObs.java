// src/main/java/com/paramonga/ssff/entities/FabConPdObs.java
package com.paramonga.ssff.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FAB_CON_PD_OBS")
public class FabConPdObs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fab_con_pd_obs")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fab_con_pd_cab", nullable = false)
    private FabConPdCab cabecera;

    @Column(name = "descripcion", length = 2000)
    private String descripcion;

    @Column(name = "flag_tipo", nullable = false)
    private Integer flagTipo;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDateTime fechaNotificacion;

    /** Columnas con default en BD **/
    @Column(name = "flag_estado", insertable = false)
    private Integer flagEstado;

    @Column(name = "usr_creacion", nullable = false)
    private String usrCreacion;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "estacion_creacion", nullable = false)
    private String estacionCreacion;
}