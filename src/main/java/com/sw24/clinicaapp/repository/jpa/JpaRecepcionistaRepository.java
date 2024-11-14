package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Recepcionista;
import com.sw24.clinicaapp.repository.RecepcionistaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRecepcionistaRepository extends JpaRepository<Recepcionista, String>, RecepcionistaRepository {
    Optional<Recepcionista> findByDni(String dni);

    Optional<Recepcionista> findByLegajo(String legajo);

    void deleteByDni(String dni);

    void deleteByLegajo(String legajo);
}
