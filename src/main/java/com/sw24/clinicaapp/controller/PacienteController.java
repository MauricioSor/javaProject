package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.PacienteDTO;
import com.sw24.clinicaapp.entity.Paciente;
import com.sw24.clinicaapp.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.crearPaciente(pacienteDTO);
    }

    @GetMapping("/{dni}")
    public Paciente buscarPacientePorDni(@PathVariable String dni) {
        return pacienteService.buscarPacientePorDni(dni);
    }

    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteService.obtenerTodosLosPacientes();
    }
}
