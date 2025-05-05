package com.paramonga.ssff.repositories.prd;

import com.paramonga.ssff.entities.FabActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrdFabActividadRepository extends JpaRepository<FabActividad, Integer> {

    @Query(value = "SELECT * FROM FAB_ACTIVIDAD WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabActividad> findByEstado(Integer flagEstado);
}
