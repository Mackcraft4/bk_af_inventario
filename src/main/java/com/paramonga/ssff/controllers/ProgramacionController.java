package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.ProgramacionDTO;
import com.paramonga.ssff.services.ProgramacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/programacion")
public class ProgramacionController {

    private final ProgramacionService service;

    public ProgramacionController(ProgramacionService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<ProgramacionDTO>> listarPorDocumento(@RequestParam String env, @RequestParam String nroDoc) {
        List<ProgramacionDTO> datos = service.listarPendientesPorDocumento(env, nroDoc);
        ApiResponse<List<ProgramacionDTO>> resp = new ApiResponse<>();
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setMessage("OK");
        resp.setData(datos);
        resp.setMetadata(null);
        return resp;
    }
}