package com.paramonga.ssff.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FAB_CON_PD_DET")
public class FabConPdDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fab_con_pd_det")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fab_con_pd_cab", nullable = false)
    private FabConPdCab cabecera;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDateTime fechaNotificacion;

    @Column(name = "id_fab_tipo_masa", nullable = false)
    private Integer tipoMasa;

    @Column(name = "id_fab_actividad", nullable = false)
    private Integer actividad;

    @Column(name = "id_fab_recipiente", nullable = false)
    private Integer recipiente;

    @Column(name = "cristalizador", nullable = false)
    private Integer cristalizador;

    @Column(name = "templa", nullable = false)
    private Integer templa;

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