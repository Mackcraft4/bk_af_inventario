package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.FabActividadDTO;
import com.paramonga.ssff.services.FabActividadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabActividad")
public class FabActividadController {

    private final FabActividadService service;

    public FabActividadController(FabActividadService service) {
        this.service = service;
    }

    @GetMapping()
    public ApiResponse<List<FabActividadDTO>> findByEstado(@RequestParam String env, @RequestParam Integer estado) {
        List<FabActividadDTO> list = service.findByEstado(env, estado);
        ApiResponse<List<FabActividadDTO>> response = new ApiResponse<>();
        response.setData(list);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setMessage("Success");
        response.setMetadata(null);
        return response;
    }
}
