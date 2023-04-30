package com.gsamtechnology.msvccursos.services;

import com.gsamtechnology.msvccursos.models.Usuario;
import com.gsamtechnology.msvccursos.models.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void delete(Long id);
    Optional<Usuario> associarUsuario(Usuario usuario, Long cursoId);
    Optional<Usuario> createUsuario(Usuario usuario, Long cursoId);

    Optional<Usuario> desassociarUsuario(Usuario usuario, Long cursoId);
}
