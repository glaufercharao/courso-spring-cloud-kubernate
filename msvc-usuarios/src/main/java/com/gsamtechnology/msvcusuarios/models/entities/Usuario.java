package com.gsamtechnology.msvcusuarios.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;

}
