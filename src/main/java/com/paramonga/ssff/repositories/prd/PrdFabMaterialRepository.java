package com.paramonga.ssff.repositories.prd;

import com.paramonga.ssff.entities.FabMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrdFabMaterialRepository extends JpaRepository<FabMaterial, Integer> {

    @Query(value = "SELECT * FROM FAB_MATERIAL WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabMaterial> findByEstado(Integer flagEstado);
}
