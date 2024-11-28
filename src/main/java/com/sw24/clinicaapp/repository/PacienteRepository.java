package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository {
    Paciente save(Paciente paciente);
    Optional<Paciente> findByDni(String dni);
    List<Paciente> findAll();
}