package com.paramonga.ssff.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "fab_actividad")
public class FabActividad implements Persistable<Integer> {

    @Id
    @Column(name = "id_fab_actividad")
    private Integer idFabActividad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "flag_destino_actividad")
    private Integer flagDestinoActividad;

    @Column(name = "flag_cristalizador")
    private Integer flagCristalizador;

    @Column(name = "flag_req_actividad")
    private Integer flagReqActividad;

    @Column(name = "flag_estado")
    private Integer flagEstado;

    @Transient
    private boolean isNew = true;

    @Override
    public Integer getId() {
        return idFabActividad;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
