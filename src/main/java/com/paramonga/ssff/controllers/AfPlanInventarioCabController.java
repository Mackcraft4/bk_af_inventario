package com.paramonga.ssff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paramonga.ssff.entities.AfPlanInventarioCab;
import com.paramonga.ssff.services.AfPlanInventarioCabService;

@RestController
@RequestMapping("/plan")
public class AfPlanInventarioCabController {

    @Autowired
    private AfPlanInventarioCabService service;

    // crear plan anual
    @PostMapping
    public AfPlanInventarioCab crear(@RequestBody AfPlanInventarioCab cab) {
        return service.save(cab);
    }
}