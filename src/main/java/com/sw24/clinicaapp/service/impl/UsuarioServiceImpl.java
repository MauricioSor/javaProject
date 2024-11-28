package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.UsuarioReqDTO;
import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Recepcionista;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import com.sw24.clinicaapp.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Persona crearUsuario(UsuarioReqDTO usuarioReqDTO) {
        String tipoUsuario = usuarioReqDTO.getTipoUsuario();

        if ("medico".equalsIgnoreCase(tipoUsuario)){
            Medico medico = new Medico(
                    usuarioReqDTO.getDni(),
                    usuarioReqDTO.getCuil(),
                    usuarioReqDTO.getApellido(),
                    usuarioReqDTO.getNombre(),
                    usuarioReqDTO.getFechaNacimiento(),
                    usuarioReqDTO.getDireccion(),
                    usuarioReqDTO.getLocalidad(),
                    usuarioReqDTO.getProvincia(),
                    usuarioReqDTO.getPais(),
                    usuarioReqDTO.getEmail(),
                    usuarioReqDTO.getTelefono(),
                    usuarioReqDTO.getMatricula(),
                    usuarioReqDTO.getEspecialidad(),
                    EstadoPersona.ACTIVO
            );

            Usuario<Persona> usuario = new Usuario<>(medico, usuarioReqDTO.getUsuario(), passwordEncoder.encode(usuarioReqDTO.getPassword()));
            usuarioRepository.save(usuario);
            return medico;

        } else if ("recepcionista".equalsIgnoreCase(tipoUsuario)) {
            Recepcionista recepcionista = new Recepcionista(
                    usuarioReqDTO.getDni(),
                    usuarioReqDTO.getCuil(),
                    usuarioReqDTO.getApellido(),
                    usuarioReqDTO.getNombre(),
                    usuarioReqDTO.getFechaNacimiento(),
                    usuarioReqDTO.getDireccion(),
                    usuarioReqDTO.getLocalidad(),
                    usuarioReqDTO.getProvincia(),
                    usuarioReqDTO.getPais(),
                    usuarioReqDTO.getEmail(),
                    usuarioReqDTO.getTelefono(),
                    usuarioReqDTO.getLegajo(),
                    EstadoPersona.ACTIVO
            );

            Usuario<Persona> usuario = new Usuario<>(recepcionista, usuarioReqDTO.getUsuario(), passwordEncoder.encode(usuarioReqDTO.getPassword()));
            usuarioRepository.save(usuario);
            return recepcionista;
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

    @Override
    public Usuario<Persona> iniciarSesion(String usuario, String password) {
        Usuario<Persona> usuarioDB = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (passwordEncoder.matches(password, usuarioDB.getPassword())) {
            return usuarioDB;
        } else {
            throw new IllegalArgumentException("Usuario o contraseña incorrectos");
        }
    }
}
