package com.v1.consultorio.controllers;

import com.v1.consultorio.models.Diagnostico;
import com.v1.consultorio.models.Evolucion;
import com.v1.consultorio.models.Paciente;
import com.v1.consultorio.services.DiagnosticoService;
import com.v1.consultorio.services.EvolucionService;
import com.v1.consultorio.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final DiagnosticoService diagnosticoService;
    private final EvolucionService evolucionService;
    public PacienteController(PacienteService pacienteService, DiagnosticoService diagnosticoService,EvolucionService evolucionService) {
        this.pacienteService = pacienteService;
        this.diagnosticoService = diagnosticoService;
        this.evolucionService=evolucionService;
    }

    @GetMapping("")
    public String home(){return "api pacientes";}

    @GetMapping("/getPaciente")
    public ResponseEntity<Paciente> getPaciente(@RequestParam String parameter) {

        Paciente paciente = pacienteService.getPaciente(parameter);

//        // Verificar si se encontró el paciente
//        if (paciente != null) {
//            return ResponseEntity.ok(paciente);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 si no se encuentra
//        }


        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }
   @GetMapping("/getHistoriaClinica")
   public ResponseEntity<List<Diagnostico>> getHistoriaClinica(@RequestParam int idHistoriaClinica){
        List<Diagnostico> diagnosticos = diagnosticoService.getDiagnostico(idHistoriaClinica);
    if(diagnosticos!= null){
        return ResponseEntity.ok(diagnosticos);
    }else{
        return ResponseEntity.notFound().build();
    }
   }
    @GetMapping("/getEvolciones")
    public ResponseEntity<List<Evolucion>> getEvoluciones(@RequestParam int idHistoriaClinica){
        List<Evolucion> evoluciones = evolucionService.getEvoluciones(idHistoriaClinica);
        if(evoluciones!= null){
            return ResponseEntity.ok(evoluciones);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
