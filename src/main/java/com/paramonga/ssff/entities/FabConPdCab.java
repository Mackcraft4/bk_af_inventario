package com.paramonga.ssff.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "FAB_CON_PD_CAB")
public class FabConPdCab implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fab_con_pd_cab")
    private Integer id;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDate fechaNotificacion;

    @Column(name = "turno", nullable = false)
    private Integer turno;

    @Column(name = "maestro_azucarero", nullable = false)
    private String maestroAzucarero;

    /** Columnas con valor por defecto en BD **/
    @Column(name = "flag_estado", insertable = false)
    private Integer flagEstado;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "usr_creacion", length = 20)
    private String usrCreacion;

    @Column(name = "estacion_creacion", length = 50)
    private String estacionCreacion;

    @Column(name = "supervisor")
    private String supervisor;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "firma")
    private byte[] firma;

    /** Relaciones OneToMany con cascada total y eliminación de huérfanos **/
    @OneToMany(mappedBy = "cabecera",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FabConPdDet> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "cabecera",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FabConPdAgua> aguas = new ArrayList<>();

    @OneToMany(mappedBy = "cabecera",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FabConPdNivel> niveles = new ArrayList<>();

    @OneToMany(mappedBy = "cabecera",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FabConPdObs> observaciones = new ArrayList<>();

    /** Para forzar INSERT sin SELECT previo **/
    @Transient
    private boolean isNew = true;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}