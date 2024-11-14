package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.request.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.response.EvolucionResDTO;
import com.sw24.clinicaapp.service.EvolucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historia-clinicas/{historiaClinicaId}/evoluciones")
public class EvolucionController {

    private final EvolucionService evolucionService;

    public EvolucionController(EvolucionService evolucionService) {
        this.evolucionService = evolucionService;
    }

    @PostMapping
    public ResponseEntity<EvolucionResDTO> crearEvolucion(@PathVariable Integer historiaClinicaId, @RequestBody EvolucionReqDTO evolucionReqDTO) {
        EvolucionResDTO evolucion = evolucionService.crearEvolucion(historiaClinicaId, evolucionReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(evolucion);
    }
}
