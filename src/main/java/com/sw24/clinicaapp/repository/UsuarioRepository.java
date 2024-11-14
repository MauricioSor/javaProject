package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional findByUsuario(String usuario);
    List<Usuario> findAll();
    void deleteByUsuario(String usuario);
}
