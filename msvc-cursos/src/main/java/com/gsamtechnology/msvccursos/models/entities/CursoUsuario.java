package com.gsamtechnology.msvccursos.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_cursos_usuarios")
@Data
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id")
    private  Long usuarioId;

}
