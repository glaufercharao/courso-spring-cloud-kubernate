package com.gsamtechnology.msvcusuarios.services;

import com.gsamtechnology.msvcusuarios.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Long id);
}
