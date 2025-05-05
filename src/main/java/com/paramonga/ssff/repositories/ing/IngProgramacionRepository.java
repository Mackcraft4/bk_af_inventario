package com.paramonga.ssff.repositories.ing;

import com.paramonga.ssff.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngProgramacionRepository extends JpaRepository<Programacion, String> {
    List<Programacion> findByNroDoc(String nroDoc);
}
