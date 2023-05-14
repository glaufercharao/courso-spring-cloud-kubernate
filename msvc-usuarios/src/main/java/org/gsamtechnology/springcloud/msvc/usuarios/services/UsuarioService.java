package org.gsamtechnology.springcloud.msvc.usuarios.services;

import org.gsamtechnology.springcloud.msvc.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void remove(Long id);
    List<Usuario> findByIds(Iterable<Long> ids);

    Optional<Usuario> findByEmail(String email);
    boolean exitsByEmail(String email);
}
