package com.paramonga.ssff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.paramonga.ssff.entities.ProductoGeneral;

@Repository
public interface ProductoGeneralRepository extends JpaRepository<ProductoGeneral, String> {
}