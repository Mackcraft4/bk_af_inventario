package com.paramonga.ssff.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paramonga.ssff.dto.AfCronInventarioDtDTO;
import com.paramonga.ssff.services.AfCronInventarioDtService;

@RestController
@RequestMapping("/cron")
public class AfCronInventarioDtController {

    @Autowired
    private AfCronInventarioDtService service;

    @GetMapping("/app/{idUser}")
    public List<AfCronInventarioDtDTO> obtenerCronograma(@PathVariable String idUser) {
        return service.obtenerPorUsuario(idUser);
    
    }

    @GetMapping("/app")
public List<AfCronInventarioDtDTO> listarTodos() {
    return service.listarTodos();
}

@GetMapping("/app/id/{id}")
public AfCronInventarioDtDTO obtenerPorId(@PathVariable Long id) {
    return service.obtenerPorId(id);
}
@PutMapping("/app/{id}")
public AfCronInventarioDtDTO actualizar(@PathVariable Long id,
                                        @RequestBody AfCronInventarioDtDTO dto) {
    return service.actualizar(id, dto);
}
// ✔ POST
@PostMapping("/app")
public AfCronInventarioDtDTO crear(@RequestBody AfCronInventarioDtDTO dto) {
    return service.crear(dto);
}

// ✔ DELETE
@DeleteMapping("/app/{id}")
public void eliminar(@PathVariable Long id) {
    service.eliminar(id);
}
}
