package com.v1.consultorio.services;

import com.v1.consultorio.models.Rol;
import com.v1.consultorio.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Método para obtener todos los roles
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    // Método para buscar un rol por su ID
    public Rol buscarPorId(Integer idRol) {
        return rolRepository.findById(idRol).orElse(null);
    }

    // Método para crear o actualizar un rol
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Método para eliminar un rol por su ID
    public void eliminarRol(Integer idRol) {
        rolRepository.deleteById(idRol);
    }
}