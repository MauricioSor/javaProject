package com.v1.consultorio.controllers;

import com.v1.consultorio.models.Paciente;
import com.v1.consultorio.models.Rol;
import com.v1.consultorio.models.Usuario;
import com.v1.consultorio.services.PacienteService;
import com.v1.consultorio.services.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("")
    public String home(){return "api pacientes";}

    @GetMapping("/getPaciente")
    public ResponseEntity<Paciente> getPaciente(@RequestParam String parameter) {

        Paciente paciente = pacienteService.getPaciente(parameter);

        // Verificar si se encontró el paciente
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 si no se encuentra
        }
    }
}
