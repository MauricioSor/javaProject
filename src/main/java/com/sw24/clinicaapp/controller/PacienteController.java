package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.DiagnosticoReqDTO;
import com.sw24.clinicaapp.dto.PacienteReqDTO;
import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.entity.HistoriaClinica;
import com.sw24.clinicaapp.entity.Paciente;
import com.sw24.clinicaapp.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteReqDTO pacienteReqDTO){
        Paciente paciente = pacienteService.crearPaciente(pacienteReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Paciente> buscarPacientePorDni(@PathVariable String dni) {
        Paciente paciente = pacienteService.buscarPacientePorDni(dni);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/{dni}/historia-clinica")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinica(@PathVariable String dni) {
        HistoriaClinica historiaClinica = pacienteService.obtenerHistoriaClinica(dni);
        return ResponseEntity.ok(historiaClinica);
    }

    @PostMapping("/{dni}/historia-clinica/diagnosticos")
    public ResponseEntity<String> crearDiagnostico(@PathVariable String dni, @RequestBody DiagnosticoReqDTO diagnosticoDTO) {
        pacienteService.crearDiagnostico(dni, diagnosticoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Diagnostico creado con exito");
    }

    @PostMapping("/{dni}/historia-clinica/diagnosticos/{idDiagnostico}/evoluciones")
    public ResponseEntity<String> agregarEvolucion(@PathVariable String dni, @PathVariable UUID idDiagnostico, @RequestBody EvolucionReqDTO evolucionReqDTO) {
        pacienteService.agregarEvolucion(dni, idDiagnostico, evolucionReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Evolucion agregada con exito");
    }
}