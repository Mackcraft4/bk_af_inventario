package com.paramonga.ssff.controllers;

import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.dto.FabMaterialDTO;
import com.paramonga.ssff.services.FabMaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fabMaterial")
public class FabMaterialController {

    private final FabMaterialService service;

    public FabMaterialController(FabMaterialService service) {
        this.service = service;
    }

    @GetMapping()
    public ApiResponse<List<FabMaterialDTO>> findByEstado(@RequestParam String env, @RequestParam Integer estado) {
        List<FabMaterialDTO> list = service.findByEstado(env, estado);
        ApiResponse<List<FabMaterialDTO>> response = new ApiResponse<>();
        response.setData(list);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setMessage("Success");
        response.setMetadata(null);
        return response;
    }
}
