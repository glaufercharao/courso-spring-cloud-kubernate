package com.gsamtechnology.msvccursos.resources;

import com.gsamtechnology.msvccursos.models.entities.Curso;
import com.gsamtechnology.msvccursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Curso>> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@Valid @RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(curso));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id,@Valid @RequestBody Curso curso){
        Optional<Curso> cursoRetorno = service.findById(id);
        if(cursoRetorno.isPresent()){
            curso.setId(cursoRetorno.get().getId());
            return ResponseEntity.ok(service.save(curso));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Curso> cursoRetorno = service.findById(id);
        if(cursoRetorno.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}