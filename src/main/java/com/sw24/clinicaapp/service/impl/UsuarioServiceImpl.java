package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.UsuarioDTO;
import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Recepcionista;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.MedicoRepository;
import com.sw24.clinicaapp.repository.RecepcionistaRepository;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import com.sw24.clinicaapp.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final MedicoRepository medicoRepository;
    private final RecepcionistaRepository recepcionistaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(MedicoRepository medicoRepository, RecepcionistaRepository recepcionistaRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.recepcionistaRepository = recepcionistaRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Persona crearUsuario(UsuarioDTO usuarioDTO) {
        String tipoUsuario = usuarioDTO.getTipoUsuario();

        if ("medico".equalsIgnoreCase(tipoUsuario)){
            Medico medico = Medico.builder()
                    .dni(usuarioDTO.getDni())
                    .cuil(usuarioDTO.getCuil())
                    .apellido(usuarioDTO.getApellido())
                    .nombre(usuarioDTO.getNombre())
                    .fechaNacimiento(usuarioDTO.getFechaNacimiento())
                    .direccion(usuarioDTO.getDireccion())
                    .localidad(usuarioDTO.getLocalidad())
                    .provincia(usuarioDTO.getProvincia())
                    .pais(usuarioDTO.getPais())
                    .email(usuarioDTO.getEmail())
                    .telefono(usuarioDTO.getTelefono())
                    .matricula(usuarioDTO.getMatricula())
                    .especialidad(usuarioDTO.getEspecialidad())
                    .estadoPersona(EstadoPersona.ACTIVO)
                    .build();

            Medico savedMedico = medicoRepository.save(medico);
            Usuario<Medico> usuario = new Usuario<>(savedMedico, usuarioDTO.getUsuario(), passwordEncoder.encode(usuarioDTO.getPassword()));
            usuarioRepository.save(usuario);
            return savedMedico;

        } else if ("recepcionista".equalsIgnoreCase(tipoUsuario)) {
            Recepcionista recepcionista = Recepcionista.builder()
                    .dni(usuarioDTO.getDni())
                    .cuil(usuarioDTO.getCuil())
                    .apellido(usuarioDTO.getApellido())
                    .nombre(usuarioDTO.getNombre())
                    .fechaNacimiento(usuarioDTO.getFechaNacimiento())
                    .direccion(usuarioDTO.getDireccion())
                    .localidad(usuarioDTO.getLocalidad())
                    .provincia(usuarioDTO.getProvincia())
                    .pais(usuarioDTO.getPais())
                    .email(usuarioDTO.getEmail())
                    .telefono(usuarioDTO.getTelefono())
                    .legajo(usuarioDTO.getLegajo())
                    .estadoPersona(EstadoPersona.ACTIVO)
                    .build();

            Recepcionista savedRecepcionista = recepcionistaRepository.save(recepcionista);
            Usuario<Recepcionista> usuario = new Usuario<>(savedRecepcionista, usuarioDTO.getUsuario(), passwordEncoder.encode(usuarioDTO.getPassword()));
            usuarioRepository.save(usuario);
            return savedRecepcionista;
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }
}
