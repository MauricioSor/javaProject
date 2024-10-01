package com.v1.consultorio.repositories;

import com.v1.consultorio.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}