package com.paramonga.ssff.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramonga.ssff.dto.ScanInventarioDTO;
import com.paramonga.ssff.entities.ProductoGeneral;
import com.paramonga.ssff.entities.AfRegisInventarioPba;
import com.paramonga.ssff.repositories.ProductoGeneralRepository;
import com.paramonga.ssff.repositories.AfRegisInventarioPbaRepository;

import java.util.Optional;

@Service
public class AfRegisInventarioPbaServiceImpl {

    @Autowired
    private ProductoGeneralRepository productoRepository;

    @Autowired
    private AfRegisInventarioPbaRepository regisRepository;

    public String scan(ScanInventarioDTO dto) {

        Optional<ProductoGeneral> productoOpt =
                productoRepository.findById(dto.getCodProducto());

        AfRegisInventarioPba regis = new AfRegisInventarioPba();

        // CAMPOS OBLIGATORIOS (IMPORTANTE)
        regis.setCodProduct(dto.getCodProducto());
        regis.setTypeProduct(dto.getTypeProduct()); // 👈 ESTE ERA EL ERROR
        regis.setCenco(dto.getCenco());

        // NO ENCONTRADO
        if (!productoOpt.isPresent()) {

            regis.setEstadoValidacion(3);
            regis.setObservation("NO ENCONTRADO");

            regisRepository.save(regis);

            return "NO ENCONTRADO";
        }

        ProductoGeneral producto = productoOpt.get();

        regis.setDescripcion(producto.getDescripcion());

        // MISMO CENCO
        if (producto.getCenco() != null &&
            producto.getCenco().trim().equals(dto.getCenco().trim())) {

            regis.setEstadoValidacion(1);
            regis.setObservation("OK");

            regisRepository.save(regis);

            return "OK";
        }

        // NO PERTENECE
        regis.setEstadoValidacion(2);
        regis.setObservation("NO PERTENECE");

        regisRepository.save(regis);

        return "NO PERTENECE";
    }
}