package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.DiagnosticoDTO;
import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.entity.Evolucion;
import com.sw24.clinicaapp.repository.DiagnosticoRespository;
import com.sw24.clinicaapp.service.DiagnosticoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    private final DiagnosticoRespository diagnosticoRespository;

    public DiagnosticoServiceImpl(DiagnosticoRespository diagnosticoRespository) {
        this.diagnosticoRespository = diagnosticoRespository;
    }

    @Override
    public Diagnostico crearDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = Diagnostico.builder()
                .codigo(diagnosticoDTO.getCodigo())
                .nombre(diagnosticoDTO.getNombre())
                .build();
        return diagnosticoRespository.save(diagnostico);
    }

    @Override
    public List<Evolucion> obtenerEvolucionesPorDiagnostico(Integer codigo) {
        Diagnostico diagnostico = diagnosticoRespository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Diagnostico no encontrado"));
        return diagnostico.getEvoluciones();
    }

    @Override
    public List<Diagnostico> obtenerTodosLosDiagnosticos() {
        return diagnosticoRespository.findAll();
    }
}
