package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.response.HistoriaClinicaResDTO;
import com.sw24.clinicaapp.service.HistoriaClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historia-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping("/paciente/{dni}")
    public ResponseEntity<HistoriaClinicaResDTO> obtenerHistoriaClinicaPorDniPaciente(@PathVariable String dni) {
        HistoriaClinicaResDTO historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorDniPaciente(dni);
        return ResponseEntity.ok(historiaClinica);
    }
}