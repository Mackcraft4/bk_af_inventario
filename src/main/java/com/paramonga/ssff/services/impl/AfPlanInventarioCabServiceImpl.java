package com.paramonga.ssff.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramonga.ssff.entities.AfPlanInventarioCab;
import com.paramonga.ssff.repositories.AfPlanInventarioCabRepository;
import com.paramonga.ssff.services.AfPlanInventarioCabService;

@Service
public class AfPlanInventarioCabServiceImpl implements AfPlanInventarioCabService {

    @Autowired
    private AfPlanInventarioCabRepository repository;

    @Override
    public AfPlanInventarioCab save(AfPlanInventarioCab cab) {
        return repository.save(cab);
    }

    @Override
    public List<AfPlanInventarioCab> findAll() {
        return repository.findAll();
    }
}