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
@Table(name = "fab_masa_act_rec")
public class FabMasaActRec implements Persistable<Integer> {

    @Id
    @Column(name = "id_fab_masa_act_rec")
    private Integer idFabMasaActRec;

    @Column(name = "id_fab_tipo_masa")
    private Integer idFabTipoMasa;

    @Column(name = "id_fab_actividad")
    private Integer idFabActividad;

    @Column(name = "id_fab_recipiente")
    private Integer idFabRecipiente;

    @Column(name = "flag_estado")
    private Integer flagEstado;

    @Transient
    private boolean isNew = true;

    @Override
    public Integer getId() {
        return idFabTipoMasa;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
