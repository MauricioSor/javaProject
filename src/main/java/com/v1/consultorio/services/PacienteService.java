package com.v1.consultorio.services;

import com.v1.consultorio.DAO.PacienteDAO;
import com.v1.consultorio.DAO.UsuarioDAO;
import com.v1.consultorio.models.Paciente;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PacienteService {
    private final PacienteDAO pacienteDAO;
    @Autowired
    public PacienteService(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public Paciente getPaciente(String parameter){
        return pacienteDAO.getPaciente(parameter);
    }


}
