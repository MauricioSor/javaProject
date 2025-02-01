package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.security.auth.RegisterRequest;

public interface UsuarioService {
    void crearUsuario(RegisterRequest registerRequest);
}