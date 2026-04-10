package com.paramonga.ssff.services;

import java.util.List;

import com.paramonga.ssff.dto.AfCronInventarioDtDTO;

public interface AfCronInventarioDtService {

    List<AfCronInventarioDtDTO> obtenerPorUsuario(String idUser);

    List<AfCronInventarioDtDTO> listarTodos();

    AfCronInventarioDtDTO obtenerPorId(Long id);

    AfCronInventarioDtDTO crear(AfCronInventarioDtDTO dto);

    AfCronInventarioDtDTO actualizar(Long id, AfCronInventarioDtDTO dto);

    void eliminar(Long id);

    void actualizarEstado(Integer idCron, Integer estado);
}