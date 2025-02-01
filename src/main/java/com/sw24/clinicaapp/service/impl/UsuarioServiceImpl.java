package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Recepcionista;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.UsuarioRepository;
import com.sw24.clinicaapp.security.auth.RegisterRequest;
import com.sw24.clinicaapp.service.UsuarioService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void crearUsuario(RegisterRequest registerRequest) {
        String tipoUsuario = registerRequest.getTipoUsuario();

        if ("medico".equalsIgnoreCase(tipoUsuario)){
            Medico medico = new Medico(
                    registerRequest.getDni(),
                    registerRequest.getCuil(),
                    registerRequest.getApellido(),
                    registerRequest.getNombre(),
                    registerRequest.getFechaNacimiento(),
                    registerRequest.getDireccion(),
                    registerRequest.getLocalidad(),
                    registerRequest.getProvincia(),
                    registerRequest.getPais(),
                    registerRequest.getEmail(),
                    registerRequest.getTelefono(),
                    registerRequest.getMatricula(),
                    registerRequest.getEspecialidad(),
                    EstadoPersona.ACTIVO
            );

            Usuario<Persona> usuario = new Usuario<>(medico, registerRequest.getUsuario(), passwordEncoder.encode(registerRequest.getPassword()));
            usuarioRepository.save(usuario);
        } else if ("recepcionista".equalsIgnoreCase(tipoUsuario)) {
            Recepcionista recepcionista = new Recepcionista(
                    registerRequest.getDni(),
                    registerRequest.getCuil(),
                    registerRequest.getApellido(),
                    registerRequest.getNombre(),
                    registerRequest.getFechaNacimiento(),
                    registerRequest.getDireccion(),
                    registerRequest.getLocalidad(),
                    registerRequest.getProvincia(),
                    registerRequest.getPais(),
                    registerRequest.getEmail(),
                    registerRequest.getTelefono(),
                    registerRequest.getLegajo(),
                    EstadoPersona.ACTIVO
            );

            Usuario<Persona> usuario = new Usuario<>(recepcionista, registerRequest.getUsuario(), passwordEncoder.encode(registerRequest.getPassword()));
            usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

    @Override
    public Usuario<Persona> loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}