package com.paramonga.ssff.repositories.ing;

import com.paramonga.ssff.entities.FabConPdDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngFabConPdDetRepository extends JpaRepository<FabConPdDet, Integer> {

    @Query(value = "SELECT COALESCE(MAX(templa), 0) FROM FAB_CON_PD_DET WHERE flag_estado = 1", nativeQuery = true)
    Integer findMaxTempla();
}