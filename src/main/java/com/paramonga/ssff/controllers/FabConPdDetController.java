package com.paramonga.ssff.controllers;


import com.paramonga.ssff.dto.ApiResponse;
import com.paramonga.ssff.services.FabConPdDetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/fabConPdDet")
public class FabConPdDetController {

    private final FabConPdDetService service;

    public FabConPdDetController(FabConPdDetService service) {
        this.service = service;
    }

    @GetMapping("/maxTempla")
    public ApiResponse<Integer> findMaxTempla(@RequestParam String env) {
        Integer maxTempla = service.findMaxTempla(env);
        ApiResponse<Integer> response = new ApiResponse<>();
        response.setData(maxTempla);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setMessage("Success");
        response.setMetadata(null);
        return response;
    }

}
