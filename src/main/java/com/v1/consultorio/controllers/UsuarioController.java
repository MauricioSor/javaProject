package com.v1.consultorio.controllers;

import com.v1.consultorio.models.Usuario;
import com.v1.consultorio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")  // Prefijo para las rutas relacionadas a usuarios
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/rol/{rolId}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorRol(@PathVariable Integer rolId) {
        if (rolId == null) {
            return ResponseEntity.badRequest().build(); // Maneja el caso en que rolId es null
        }

        List<Usuario> usuarios = usuarioService.obtenerUsuarios(rolId);
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();  // Retorna un 204 si no hay usuarios
        }
        return ResponseEntity.ok(usuarios);  // Retorna un 200 y la lista de usuarios
    }
//    @PostMapping("/Session")
//    public ResponseBody String LogIn(@){
//
//    }
}