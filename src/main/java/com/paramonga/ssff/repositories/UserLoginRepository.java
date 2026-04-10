package com.paramonga.ssff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paramonga.ssff.entities.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
}