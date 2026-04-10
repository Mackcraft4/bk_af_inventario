package com.paramonga.ssff.entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_login")
public class UserLogin {

    @Id
    @Column(name = "id_user")
    private String idUser;

    @Column(name = "nombre")
    private String nombre;
}