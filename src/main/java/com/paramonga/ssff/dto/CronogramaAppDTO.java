package com.paramonga.ssff.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CronogramaAppDTO {

    private String cenco;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer status;
}