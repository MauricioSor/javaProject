package com.v1.consultorio.controllers;

import com.v1.consultorio.models.Rol;
import com.v1.consultorio.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")  // Prefijo para las rutas relacionadas a roles
public class RolController {

    @Autowired
    private RolService rolService;

    // Ruta para obtener todos los roles
    @GetMapping("/todos")
    public ResponseEntity<List<Rol>> obtenerTodosLosRoles() {
        List<Rol> roles = rolService.obtenerTodosLosRoles();
        return ResponseEntity.ok(roles);
    }

    // Ruta para obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Integer id) {
        Rol rol = rolService.buscarPorId(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Ruta para crear o actualizar un rol
    @PostMapping("/guardar")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardarRol(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    // Ruta para eliminar un rol por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRol(@PathVariable Integer id) {
        rolService.eliminarRol(id);
        return ResponseEntity.ok("Rol eliminado exitosamente");
    }
}