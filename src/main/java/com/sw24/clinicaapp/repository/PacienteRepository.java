package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Paciente;

import java.util.List;

public interface PacienteRepository {
    Paciente save(Paciente paciente);
    Paciente findByDni(String dni);
    List<Paciente> findAll();
}
