package org.gsamtechnology.springcloud.msvc.cursos.services;

import org.gsamtechnology.springcloud.msvc.cursos.models.Usuario;
import org.gsamtechnology.springcloud.msvc.cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> porId(Long id);
    Optional<Curso> findUsuarioById(Long id);
    Curso save(Curso curso);
    void remove(Long id);

    void eliminarCursoUsuarioPorId(Long id);

    Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId);
    Optional<Usuario> createUsuario(Usuario usuario, Long cursoId);
    Optional<Usuario> removeUsuario(Usuario usuario, Long cursoId);
}
