package com.gsamtechnology.msvccursos.repositories;

import com.gsamtechnology.msvccursos.models.entities.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, Long> {
}
