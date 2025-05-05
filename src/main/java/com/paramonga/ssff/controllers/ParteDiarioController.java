package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.ParteDiarioDTO;
import com.paramonga.ssff.services.ParteDiarioService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/parteDiario")
public class ParteDiarioController {

    private final ParteDiarioService service;

    public ParteDiarioController(ParteDiarioService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<ParteDiarioDTO> enviarParteDiario(
            @RequestParam String env,
            @RequestBody ParteDiarioDTO dto) {
        ParteDiarioDTO result = service.enviarParteDiario(env, dto);
        ApiResponse<ParteDiarioDTO> resp = new ApiResponse<>();
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setMessage("Parte Diario Guardado satisfactoriamente");
        resp.setData(result);
        resp.setMetadata(null);
        return resp;
    }
}
