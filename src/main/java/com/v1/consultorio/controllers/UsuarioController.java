package com.v1.consultorio.controllers;

import com.v1.consultorio.models.Rol;
import com.v1.consultorio.models.Usuario;
import com.v1.consultorio.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")  // Prefijo para las rutas relacionadas a usuarios
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("")
    public String ResponseEntity(){
        return"Api usuarios";
    }
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
//    @GetMapping("/rol/{rolId}")
//    public ResponseEntity<List<Usuario>> obtenerUsuariosPorRol(@PathVariable Integer rolId) {
//        if (rolId == null) {
//            return ResponseEntity.badRequest().build(); // Maneja el caso en que rolId es null
//        }
//
//        List<Usuario> usuarios = usuarioService.obtenerUsuarios(rolId);
//        if (usuarios.isEmpty()) {
//            return ResponseEntity.noContent().build();  // Retorna un 204 si no hay usuarios
//        }
//        return ResponseEntity.ok(usuarios);  // Retorna un 200 y la lista de usuarios
//    }
    @PostMapping("/login")
    public ResponseEntity<Usuario.UsuarioResponse> login(@RequestParam String mail, @RequestParam String contraseña) {
        Usuario usuario = usuarioService.logIn(mail, contraseña);
        if (usuario != null) {
            // Crea el objeto de respuesta solo si los valores no son nulos
            String nombre = usuario.getNombre();
            String rol = usuario.getRol();
            Usuario.UsuarioResponse response = new Usuario.UsuarioResponse(
                    nombre != null ? nombre : null,
                    rol != null ? rol : null
            );
            return ResponseEntity.ok(response); // Devuelve el objeto UsuarioResponse
        } else {
            return ResponseEntity.status(401).build(); // No autorizado
        }
    }
}