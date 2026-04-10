package com.paramonga.ssff.mapper;

import org.springframework.stereotype.Component;
import com.paramonga.ssff.entities.AfRegisInventarioPba;
import com.paramonga.ssff.entities.ProductoGeneral;

@Component
public class AfRegisInventarioPbaMapper {

    public AfRegisInventarioPba toEntity(String codProducto, String cenco) {

        AfRegisInventarioPba regis = new AfRegisInventarioPba();

        regis.setCodProduct(codProducto);
        regis.setCenco(cenco);
        regis.setTypeProduct("A"); // puedes ajustar luego

        return regis;
    }

    public void completarDesdeProducto(AfRegisInventarioPba regis, ProductoGeneral producto) {

        regis.setDescripcion(producto.getDescripcion());
        regis.setModelo(null);
        regis.setNroSerie(null);
        regis.setCodMarca(null);
        regis.setObservation("OK");
    }
}