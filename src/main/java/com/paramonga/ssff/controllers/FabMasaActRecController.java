package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.FabMasaActRecDTO;
import com.paramonga.ssff.services.FabMasaActRecService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabMasaActRec")
public class FabMasaActRecController {

    private final FabMasaActRecService service;

    public FabMasaActRecController(FabMasaActRecService service) {
        this.service = service;
    }

    @GetMapping()
    public ApiResponse<List<FabMasaActRecDTO>> findByEstado(@RequestParam String env, @RequestParam Integer estado) {
        List<FabMasaActRecDTO> list = service.findByEstado(env, estado);
        ApiResponse<List<FabMasaActRecDTO>> response = new ApiResponse<>();
        response.setData(list);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setMessage("Success");
        response.setMetadata(null);
        return response;
    }
}
