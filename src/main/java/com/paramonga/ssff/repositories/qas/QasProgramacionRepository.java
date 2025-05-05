package com.paramonga.ssff.repositories.qas;

import com.paramonga.ssff.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QasProgramacionRepository extends JpaRepository<Programacion, String> {
    List<Programacion> findByNroDoc(String nroDoc);
}
