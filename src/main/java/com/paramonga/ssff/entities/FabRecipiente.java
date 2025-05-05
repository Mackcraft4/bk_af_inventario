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
@Table(name = "fab_recipiente")
public class FabRecipiente implements Persistable<Integer> {

    @Id
    @Column(name = "id_fab_recipiente")
    private Integer idFabRecipiente;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "flag_tipo")
    private Integer flagTipo;

    @Column(name = "flag_estado")
    private Integer flagEstado;

    @Transient
    private boolean isNew = true;

    @Override
    public Integer getId() {
        return idFabRecipiente;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
