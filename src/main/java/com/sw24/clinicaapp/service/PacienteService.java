package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.PacienteDTO;
import com.sw24.clinicaapp.entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente crearPaciente(PacienteDTO paciente);
    Paciente buscarPacientePorDni(String dni);
    List<Paciente> obtenerTodosLosPacientes();
}