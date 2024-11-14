package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    Medico save(Medico medico);
    Optional<Medico> findByDni(String dni);
    Optional<Medico> findByMatricula(String matricula);
    List<Medico> findAll();
    void deleteByDni(String dni);
    void deleteByMatricula(String matricula);
}
