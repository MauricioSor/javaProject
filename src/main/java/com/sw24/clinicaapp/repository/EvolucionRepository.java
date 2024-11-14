package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Evolucion;

import java.util.List;
import java.util.Optional;

public interface EvolucionRepository {
    Evolucion save(Evolucion evolucion);
    Optional<Evolucion> findById(Integer id);
    List<Evolucion> findAll();
    void deleteById(Integer id);
}
