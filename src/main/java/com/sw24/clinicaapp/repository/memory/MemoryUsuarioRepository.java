package com.sw24.clinicaapp.repository.memory;

import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("memory")
public class MemoryUsuarioRepository implements UsuarioRepository {
    private final ConcurrentHashMap<String, Usuario<Persona>> storage = new ConcurrentHashMap<>();

    @Override
    public Usuario<Persona> save(Usuario<Persona> usuario) {
        storage.putIfAbsent(usuario.getPersona().getDni(), usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario<Persona>> findByUsuario(String usuario) {
        return storage.values().stream()
                .filter(u -> usuario.equals(u.getUsuario()))
                .findFirst();
    }

    @Override
    public Optional<Usuario<Persona>> findByDni(String dni) {
        return Optional.ofNullable(storage.get(dni));
    }

    @Override
    public List<Usuario<Persona>> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteByUsuario(String usuario) {
        storage.remove(usuario);
    }
}