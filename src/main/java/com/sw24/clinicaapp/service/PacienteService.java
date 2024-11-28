package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.DiagnosticoReqDTO;
import com.sw24.clinicaapp.dto.PacienteReqDTO;
import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.entity.HistoriaClinica;
import com.sw24.clinicaapp.entity.Paciente;

import java.util.UUID;

public interface PacienteService {
    Paciente crearPaciente(PacienteReqDTO paciente);
    Paciente buscarPacientePorDni(String dniPaciente);
    HistoriaClinica obtenerHistoriaClinica(String dniPaciente);
    void agregarEvolucion(String dniPaciente, UUID idDiagnostico, EvolucionReqDTO evolucionReqDTO);
    void crearDiagnostico(String dni, DiagnosticoReqDTO diagnosticoDTO);
}