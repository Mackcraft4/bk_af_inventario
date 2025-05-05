package com.paramonga.ssff.repositories.ing;

import com.paramonga.ssff.entities.FabTipoMasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngFabTipoMasaRepository extends JpaRepository<FabTipoMasa, Integer> {

    @Query(value = "SELECT * FROM FAB_TIPO_MASA WHERE FLAG_ESTADO = :#{#flagEstado}", nativeQuery = true)
    List<FabTipoMasa> findByEstado(Integer flagEstado);
}
