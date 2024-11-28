package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario<Persona> save(Usuario<Persona> usuario);
    Optional<Usuario<Persona>> findByUsuario(String usuario);
    Optional<Usuario<Persona>> findByDni(String dni);
    List<Usuario<Persona>> findAll();
    void deleteByUsuario(String usuario);
}