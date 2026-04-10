package com.paramonga.ssff.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paramonga.ssff.entities.AfCronInventarioDt;

public interface AfCronInventarioDtRepository extends JpaRepository<AfCronInventarioDt, Integer> {

    List<AfCronInventarioDt> findByIdUser(String idUser);

    @Query("SELECT c.idCron, c.idUser, c.idCab, cab.cencos, c.startAt, c.endAt, c.status " +
            "FROM AfCronInventarioDt c " +
            "JOIN AfPlanInventarioCab cab ON c.idCab = cab.idCab " +
            "WHERE c.idUser = :idUser")
    List<Object[]> obtenerCronConCenco(@Param("idUser") String idUser);
}