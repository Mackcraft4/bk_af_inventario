package com.paramonga.ssff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paramonga.ssff.dto.ScanInventarioDTO;
import com.paramonga.ssff.services.impl.AfRegisInventarioPbaServiceImpl;

@RestController
@RequestMapping("/inventario")
public class AfRegisInventarioPbaController {

    @Autowired
    private AfRegisInventarioPbaServiceImpl service;

    @PostMapping("/scan")
    public String scan(@RequestBody ScanInventarioDTO dto) {
        return service.scan(dto);
    }
}