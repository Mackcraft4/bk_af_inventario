package com.paramonga.ssff.repositories.dev;

import com.paramonga.ssff.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevProgramacionRepository extends JpaRepository<Programacion, String> {
    List<Programacion> findByNroDoc(String nroDoc);
}
