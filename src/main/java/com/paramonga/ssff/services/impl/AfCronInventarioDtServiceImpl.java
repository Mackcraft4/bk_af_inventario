package com.paramonga.ssff.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramonga.ssff.dto.AfCronInventarioDtDTO;
import com.paramonga.ssff.entities.AfCronInventarioDt;
import com.paramonga.ssff.mapper.AfCronInventarioDtMapper;
import com.paramonga.ssff.repositories.AfCronInventarioDtRepository;
import com.paramonga.ssff.repositories.AfPlanInventarioDetRepository;
import com.paramonga.ssff.services.AfCronInventarioDtService;

@Service
public class AfCronInventarioDtServiceImpl implements AfCronInventarioDtService {

    @Autowired
    private AfCronInventarioDtRepository repository;

    @Autowired
    private AfCronInventarioDtMapper mapper;

    // ✔ GET por usuario (ya lo tenías)
    @Override
    public List<AfCronInventarioDtDTO> obtenerPorUsuario(String idUser) {

        List<Object[]> results = repository.obtenerCronConCenco(idUser);

        return results.stream().map(obj -> {
            AfCronInventarioDtDTO dto = new AfCronInventarioDtDTO();

            dto.setIdCron((Integer) obj[0]);
            dto.setIdUser((String) obj[1]);
            dto.setIdCab((Integer) obj[2]);
            dto.setCencos(((String) obj[3]).trim());
            dto.setStartAt((LocalDateTime) obj[4]);
            dto.setEndAt((LocalDateTime) obj[5]);
            dto.setStatus((Integer) obj[6]);

            return dto;
        }).collect(java.util.stream.Collectors.toList());
    }

    // ✔ GET TODOS
    @Override
    public List<AfCronInventarioDtDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // ✔ GET POR ID
    @Override
    public AfCronInventarioDtDTO obtenerPorId(Long id) {
        AfCronInventarioDt entity = repository.findById(id.intValue())
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        return mapper.toDTO(entity);
    }

    // ✔ POST (crear)
    @Autowired
    private AfPlanInventarioDetRepository planDetRepository;

    @Override
    public AfCronInventarioDtDTO crear(AfCronInventarioDtDTO dto) {

        // 🔥 VALIDACIÓN
        if (!planDetRepository.existsByIdCabAndIdUser(dto.getIdCab(), dto.getIdUser())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Usuario no pertenece al plan");
        }

        AfCronInventarioDt entity = mapper.toEntity(dto);
        AfCronInventarioDt saved = repository.save(entity);

        return mapper.toDTO(saved);
    }

    // ✔ PUT (actualizar)
    @Override
    public AfCronInventarioDtDTO actualizar(Long id, AfCronInventarioDtDTO dto) {
        AfCronInventarioDt entity = repository.findById(id.intValue())
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        // ⚠️ ajusta estos campos según tu entidad real
        entity.setStatus(dto.getStatus());
        entity.setIdUser(dto.getIdUser());

        return mapper.toDTO(repository.save(entity));
    }

    // ✔ DELETE
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id.intValue());
    }

    // ✔ (opcional) actualizar estado (ya lo tenías)
    @Override
    public void actualizarEstado(Integer idCron, Integer estado) {
        AfCronInventarioDt cron = repository.findById(idCron)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        cron.setStatus(estado);
        repository.save(cron);
    }
}