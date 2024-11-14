package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.MedicoDTO;
import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> crearMedico(@RequestBody MedicoDTO medicoDTO) {
        Medico medico = medicoService.crearMedico(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }
}
