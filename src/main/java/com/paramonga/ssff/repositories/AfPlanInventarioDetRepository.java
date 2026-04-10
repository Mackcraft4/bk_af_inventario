package com.paramonga.ssff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paramonga.ssff.entities.AfPlanInventarioDet;

public interface AfPlanInventarioDetRepository extends JpaRepository<AfPlanInventarioDet, Integer> {

    boolean existsByIdCabAndIdUser(Integer idCab, String idUser);

}