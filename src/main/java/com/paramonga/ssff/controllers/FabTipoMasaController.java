package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.FabTipoMasaDTO;
import com.paramonga.ssff.services.FabTipoMasaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabTipoMasa")
public class FabTipoMasaController {

    private final FabTipoMasaService service;

    public FabTipoMasaController(FabTipoMasaService service) {
        this.service = service;
    }

    @GetMapping()
    public ApiResponse<List<FabTipoMasaDTO>> findByEstado(@RequestParam String env, @RequestParam Integer estado) {
        List<FabTipoMasaDTO> list = service.findByEstado(env, estado);
        ApiResponse<List<FabTipoMasaDTO>> response = new ApiResponse<>();
        response.setData(list);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setMessage("Success");
        response.setMetadata(null);
        return response;
    }
}
