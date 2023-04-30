package com.gsamtechnology.msvccursos.clients;

import com.gsamtechnology.msvccursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "msvc_usuarios", url = "localhost:8001")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    Usuario findById(@PathVariable Long id);
    @PostMapping("/")
    Usuario save(@RequestBody Usuario usuario);
}
