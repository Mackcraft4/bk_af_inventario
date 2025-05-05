package com.paramonga.ssff.repositories.prd;

import com.paramonga.ssff.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrdProgramacionRepository extends JpaRepository<Programacion, String> {
    List<Programacion> findByNroDoc(String nroDoc);
}
