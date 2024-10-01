package com.v1.consultorio.services;

import com.v1.consultorio.DAO.UsuarioDAO;
import com.v1.consultorio.models.Usuario;
import com.v1.consultorio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioDAO usuarioDAO;
    @Autowired
    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> obtenerUsuarios(int rolId) {
        return usuarioDAO.obtenerUsuariosPorRol(rolId);
    }
}