package com.paramonga.ssff.repositories.qas;

import com.paramonga.ssff.entities.FabMasaActRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QasFabMasaActRecRepository extends JpaRepository<FabMasaActRec, Integer> {

    @Query(value = "SELECT * FROM FAB_MASA_ACT_REC WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabMasaActRec> findByEstado(Integer flagEstado);
}
