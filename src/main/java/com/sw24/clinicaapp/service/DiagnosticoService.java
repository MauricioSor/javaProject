package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.DiagnosticoDTO;
import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.entity.Evolucion;

import java.util.List;

public interface DiagnosticoService {
    Diagnostico crearDiagnostico(DiagnosticoDTO diagnosticoDTO);
    List<Evolucion> obtenerEvolucionesPorDiagnostico(Integer codigo);
    List<Diagnostico> obtenerTodosLosDiagnosticos();
}
