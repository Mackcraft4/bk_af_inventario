package com.paramonga.ssff.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "af_plan_inventario_cab")
public class AfPlanInventarioCab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cab")
    private Integer idCab;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private String month;

    @Column(name = "cencos")
    private String cencos;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;

    @Column(name = "valid_to")
    private LocalDateTime validTo;

    @Column(name = "station")
    private String station;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modify_at")
    private LocalDateTime modifyAt;
}