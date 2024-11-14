package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.PacienteDTO;
import com.sw24.clinicaapp.entity.Paciente;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.PacienteRepository;
import com.sw24.clinicaapp.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = Paciente.builder()
                .dni(pacienteDTO.getDni())
                .cuil(pacienteDTO.getCuil())
                .apellido(pacienteDTO.getApellido())
                .nombre(pacienteDTO.getNombre())
                .fechaNacimiento(pacienteDTO.getFechaNacimiento())
                .direccion(pacienteDTO.getDireccion())
                .localidad(pacienteDTO.getLocalidad())
                .provincia(pacienteDTO.getProvincia())
                .pais(pacienteDTO.getPais())
                .email(pacienteDTO.getEmail())
                .telefono(pacienteDTO.getTelefono())
                .estadoPersona(EstadoPersona.ACTIVO)
                .pasaporte(pacienteDTO.getPasaporte())
                .obraSocial(pacienteDTO.getObraSocial())
                .nroAfiliado(pacienteDTO.getNroAfiliado())
                .build();
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacientePorDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }
}