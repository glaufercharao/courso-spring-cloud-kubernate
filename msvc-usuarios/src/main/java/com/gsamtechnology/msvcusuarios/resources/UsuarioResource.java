package com.gsamtechnology.msvcusuarios.resources;

import com.gsamtechnology.msvcusuarios.entities.Usuario;
import com.gsamtechnology.msvcusuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        Optional<Usuario> usuarioRetorno = service.findById(id);
        if(usuarioRetorno.isPresent()){
            usuario.setId(usuarioRetorno.get().getId());
            return ResponseEntity.ok(service.save(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> usuarioRetorno = service.findById(id);
        if(usuarioRetorno.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}