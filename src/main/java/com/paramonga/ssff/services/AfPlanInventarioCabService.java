package com.paramonga.ssff.services;

import java.util.List;
import com.paramonga.ssff.entities.AfPlanInventarioCab;

public interface AfPlanInventarioCabService {

    AfPlanInventarioCab save(AfPlanInventarioCab cab);

    List<AfPlanInventarioCab> findAll();
}