package com.paramonga.ssff.repositories.dev;

import com.paramonga.ssff.entities.FabActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DevFabActividadRepository extends JpaRepository<FabActividad, Integer> {

    @Query(value = "SELECT * FROM FAB_ACTIVIDAD WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabActividad> findByEstado(Integer flagEstado);
}
