package com.gsamtechnology.msvcusuarios.repositories;

import com.gsamtechnology.msvcusuarios.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
