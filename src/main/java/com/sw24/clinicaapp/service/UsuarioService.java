package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.UsuarioDTO;
import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Usuario;

public interface UsuarioService {
    Persona crearUsuario(UsuarioDTO usuarioDTO);
    Usuario<Persona> iniciarSesion(String usuario, String password);
}