package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.DiagnosticoDTO;
import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.service.DiagnosticoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping
    public ResponseEntity<Diagnostico> crearDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO){
        Diagnostico diagnostico = diagnosticoService.crearDiagnostico(diagnosticoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnostico);
    }

    @GetMapping
    public List<Diagnostico> obtenerTodosLosDiagnosticos() {
        return diagnosticoService.obtenerTodosLosDiagnosticos();
    }
}
