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
@Table(name = "fab_material")
public class FabMaterial implements Persistable<Integer> {

    @Id
    @Column(name = "id_fab_material")
    private Integer idFabMaterial;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "desc_corta")
    private String descCorta;

    @Column(name = "flag_estado")
    private Integer flagEstado;

    @Transient
    private boolean isNew = true;

    @Override
    public Integer getId() {
        return idFabMaterial;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
