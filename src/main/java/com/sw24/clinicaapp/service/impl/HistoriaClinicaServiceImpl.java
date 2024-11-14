package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.response.HistoriaClinicaResDTO;
import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.entity.Evolucion;
import com.sw24.clinicaapp.entity.HistoriaClinica;
import com.sw24.clinicaapp.mapper.HistoriaClinicaMapper;
import com.sw24.clinicaapp.repository.HistoriaClinicaRepository;
import com.sw24.clinicaapp.service.HistoriaClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final HistoriaClinicaMapper historiaClinicaMapper = HistoriaClinicaMapper.INSTANCE;


    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinicaResDTO obtenerHistoriaClinicaPorDniPaciente(String dni) {
        HistoriaClinica historiaClinica = historiaClinicaRepository.findByPacienteDni(dni)
                .orElseThrow(() -> new IllegalArgumentException("Historia Clinica no encontrada"));

        // Filtrar las evoluciones que pertenecen a esta historia clinica
        List<Diagnostico> diagnosticosFiltrados = historiaClinica.getDiagnosticos().stream()
                .peek(diagnostico -> {
                    List<Evolucion> evolucionesFiltradas = diagnostico.getEvoluciones().stream()
                            .filter(evolucion -> evolucion.getHistoriaClinica().equals(historiaClinica))
                            .collect(Collectors.toList());
                    diagnostico.setEvoluciones(evolucionesFiltradas);
                })
                .collect(Collectors.toList());

        historiaClinica.setDiagnosticos(diagnosticosFiltrados);

        return historiaClinicaMapper.toHistoriaClinicaDTO(historiaClinica);
    }
}