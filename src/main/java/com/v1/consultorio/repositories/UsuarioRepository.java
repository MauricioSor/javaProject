package com.v1.consultorio.repositories;

import com.v1.consultorio.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Método para buscar un usuario por su nombre
    Optional<Usuario> findByNombre(String nombre);

    // Método para buscar un usuario por su correo
    Optional<Usuario> findByMail(String mail);
}