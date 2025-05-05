package com.paramonga.ssff.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FAB_CON_PD_AGUA")
public class FabConPdAgua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fab_con_pd_agua")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fab_con_pd_cab", nullable = false)
    private FabConPdCab cabecera;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDateTime fechaNotificacion;

    @Column(name = "n_recipientes", nullable = false)
    private Integer nRecipientes;

    @Column(name = "p_sig", nullable = false)
    private double pSig;

    @Column(name = "flag_tipo", nullable = false)
    private Integer flagTipo;

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
