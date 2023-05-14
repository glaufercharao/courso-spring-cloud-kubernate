package org.gsamtechnology.springcloud.msvc.usuarios.services;

import org.gsamtechnology.springcloud.msvc.usuarios.clients.CursoClienteRest;
import org.gsamtechnology.springcloud.msvc.usuarios.models.entity.Usuario;
import org.gsamtechnology.springcloud.msvc.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CursoClienteRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
        client.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findByIds(Iterable<Long> ids) {
        return (List<Usuario>) repository.findAllById(ids);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return repository.porEmail(email);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
