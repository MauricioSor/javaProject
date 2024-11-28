package com.sw24.clinicaapp.controller;

import com.sw24.clinicaapp.dto.UsuarioReqDTO;
import com.sw24.clinicaapp.entity.Persona;
import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Persona> crearUsuario(@RequestBody UsuarioReqDTO usuarioReqDTO) {
        Persona usuario = usuarioService.crearUsuario(usuarioReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario<Persona>> iniciarSesion(@RequestBody UsuarioReqDTO usuarioReqDTO) {
        var usuario = usuarioService.iniciarSesion(usuarioReqDTO.getUsuario(), usuarioReqDTO.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
