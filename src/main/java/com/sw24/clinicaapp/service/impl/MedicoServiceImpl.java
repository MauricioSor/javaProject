package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.MedicoDTO;
import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.MedicoRepository;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import com.sw24.clinicaapp.service.MedicoService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public MedicoServiceImpl(MedicoRepository medicoRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Medico crearMedico(MedicoDTO medicoDTO) {
        Medico medico = Medico.builder()
                .dni(medicoDTO.getDni())
                .cuil(medicoDTO.getCuil())
                .apellido(medicoDTO.getApellido())
                .nombre(medicoDTO.getNombre())
                .fechaNacimiento(medicoDTO.getFechaNacimiento())
                .direccion(medicoDTO.getDireccion())
                .localidad(medicoDTO.getLocalidad())
                .provincia(medicoDTO.getProvincia())
                .pais(medicoDTO.getPais())
                .email(medicoDTO.getEmail())
                .telefono(medicoDTO.getTelefono())
                .matricula(medicoDTO.getMatricula())
                .especialidad(medicoDTO.getEspecialidad())
                .estadoPersona(EstadoPersona.ACTIVO)
                .build();

        Medico savedMedico = medicoRepository.save(medico);

        Usuario<Medico> usuario = new Usuario<>(
                savedMedico, medicoDTO.getUsuario(), passwordEncoder.encode(medicoDTO.getPassword()));

        usuarioRepository.save(usuario);

        return savedMedico;
    }
}
