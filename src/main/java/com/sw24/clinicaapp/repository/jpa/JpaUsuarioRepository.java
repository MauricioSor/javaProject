package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<Usuario, Integer>, UsuarioRepository {
    Optional<Usuario> findByUsuario(String usuario);
}
