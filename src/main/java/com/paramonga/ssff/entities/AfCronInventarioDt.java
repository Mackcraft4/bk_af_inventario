package com.paramonga.ssff.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "af_cron_inventario_dt")
public class AfCronInventarioDt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cron_seq")
    @SequenceGenerator(name = "cron_seq", sequenceName = "seq_cron", allocationSize = 1)
    @Column(name = "id_cron")
    private Integer idCron;

    @Column(name = "id_cab")
    private Integer idCab;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "status")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_at")
    private LocalDateTime startAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_at")
    private LocalDateTime endAt;
}