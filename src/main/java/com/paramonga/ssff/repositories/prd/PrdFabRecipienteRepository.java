package com.paramonga.ssff.repositories.prd;

import com.paramonga.ssff.entities.FabRecipiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrdFabRecipienteRepository extends JpaRepository<FabRecipiente, Integer> {

    @Query(value = "SELECT * FROM FAB_RECIPIENTE WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabRecipiente> findByEstado(Integer flagEstado);
}
