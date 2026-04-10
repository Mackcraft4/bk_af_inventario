package com.paramonga.ssff.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramonga.ssff.dto.CronogramaAppDTO;
import com.paramonga.ssff.entities.AfCronInventarioDt;
import com.paramonga.ssff.mapper.CronogramaMapper;
import com.paramonga.ssff.repositories.AfCronInventarioDtRepository;
import com.paramonga.ssff.services.CronogramaService;

@Service
public class CronogramaServiceImpl implements CronogramaService {

    @Autowired
    private AfCronInventarioDtRepository repository;

    @Autowired
    private CronogramaMapper mapper;

    @Override
    public List<CronogramaAppDTO> obtenerCronogramaPorUsuario(String idUser) {

        List<AfCronInventarioDt> lista = repository.findByIdUser(idUser);

        if (lista == null || lista.isEmpty()) {
            return List.of();
        }

        return lista.stream()
                .map(mapper::toDTO)
                .toList();
    }
}