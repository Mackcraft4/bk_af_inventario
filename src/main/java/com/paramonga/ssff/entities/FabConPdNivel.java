package com.paramonga.ssff.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FAB_CON_PD_NIVEL")
public class FabConPdNivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fab_con_pd_nivel")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fab_con_pd_cab", nullable = false)
    private FabConPdCab cabecera;

    @Column(name = "id_fab_recipiente", nullable = false)
    private Integer recipiente;

    @Column(name = "id_fab_tipo_masa")
    private Integer tipoMasa;

    @Column(name = "nivel", nullable = false)
    private double nivel;

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
