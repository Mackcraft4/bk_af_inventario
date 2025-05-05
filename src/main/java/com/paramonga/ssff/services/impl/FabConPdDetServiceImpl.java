package com.paramonga.ssff.services.impl;

import com.paramonga.ssff.repositories.dev.DevFabConPdDetRepository;
import com.paramonga.ssff.repositories.ing.IngFabConPdDetRepository;
import com.paramonga.ssff.repositories.prd.PrdFabConPdDetRepository;
import com.paramonga.ssff.repositories.qas.QasFabConPdDetRepository;
import com.paramonga.ssff.services.FabConPdDetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FabConPdDetServiceImpl implements FabConPdDetService {

    private final DevFabConPdDetRepository dev;
    private final QasFabConPdDetRepository qas;
    private final PrdFabConPdDetRepository prd;
    private final IngFabConPdDetRepository ing;

    public FabConPdDetServiceImpl(DevFabConPdDetRepository dev, QasFabConPdDetRepository qas, PrdFabConPdDetRepository prd, IngFabConPdDetRepository ing) {
        this.dev = dev;
        this.qas = qas;
        this.prd = prd;
        this.ing = ing;
    }

    @Override
    public Integer findMaxTempla(String env) {
        switch (env) {
            case "dev":
                return dev.findMaxTempla();
            case "qas":
                return qas.findMaxTempla();
            case "prd":
                return prd.findMaxTempla();
            case "ing":
                return ing.findMaxTempla();
            default:
                throw new IllegalArgumentException("El entorno '" + env + "' no es válido.");
        }
    }
}
