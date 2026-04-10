package com.paramonga.ssff.entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "af_plan_inventario_det")
public class AfPlanInventarioDet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "det_seq")
    @SequenceGenerator(name = "det_seq", sequenceName = "seq_plan_det", allocationSize = 1)
    @Column(name = "id_det")
    private Integer idDet;

    @Column(name = "id_cab")
    private Integer idCab;

    @Column(name = "id_user")
    private String idUser;
}