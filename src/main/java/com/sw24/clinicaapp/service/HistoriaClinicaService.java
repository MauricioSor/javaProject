package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.response.HistoriaClinicaResDTO;

public interface HistoriaClinicaService {
    HistoriaClinicaResDTO obtenerHistoriaClinicaPorDniPaciente(String dni);
}