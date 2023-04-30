package com.gsamtechnology.msvccursos.services.impl;

import com.gsamtechnology.msvccursos.clients.UsuarioClientRest;
import com.gsamtechnology.msvccursos.models.Usuario;
import com.gsamtechnology.msvccursos.models.entities.Curso;
import com.gsamtechnology.msvccursos.models.entities.CursoUsuario;
import com.gsamtechnology.msvccursos.repositories.CursoRepository;
import com.gsamtechnology.msvccursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository repository;

    @Autowired
    private UsuarioClientRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return ((List) repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Usuario> associarUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> curso = repository.findById(cursoId);
        if(curso.isPresent()){
            Usuario usuarioMsvc = client.findById(usuario.getId());

            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());
            curso.get().addCursoUsuario(cursoUsuario);
            repository.save(curso.get());
            return Optional.of(usuarioMsvc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> createUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> curso = repository.findById(cursoId);
        if(curso.isPresent()){
            Usuario usuarioNovoMsvc = client.save(usuario);

            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioNovoMsvc.getId());
            curso.get().addCursoUsuario(cursoUsuario);
            repository.save(curso.get());
            return Optional.of(usuarioNovoMsvc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> desassociarUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> curso = repository.findById(cursoId);
        if(curso.isPresent()){
            Usuario usuarioMsvc = client.save(usuario);

            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());
            curso.get().removeCursoUsuario(cursoUsuario);
            repository.save(curso.get());
            return Optional.of(usuarioMsvc);
        }
        return Optional.empty();
    }
}
