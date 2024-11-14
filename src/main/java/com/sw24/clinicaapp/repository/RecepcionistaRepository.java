package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Recepcionista;

import java.util.List;
import java.util.Optional;

public interface RecepcionistaRepository {
    Recepcionista save(Recepcionista recepcionista);
    Optional<Recepcionista> findByDni(String dni);
    Optional<Recepcionista> findByLegajo(String legajo);
    List<Recepcionista> findAll();
    void deleteByDni(String dni);
    void deleteByLegajo(String legajo);
}
