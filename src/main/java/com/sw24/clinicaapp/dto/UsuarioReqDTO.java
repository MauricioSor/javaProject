package com.sw24.clinicaapp.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class UsuarioReqDTO {
    private String tipoUsuario; // "medico" o "recepcionista"

    private String dni;
    private String cuil;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String email;
    private String telefono;

    private String matricula; // Solo para Medico
    private String especialidad; // Solo para Medico
    private String legajo; // Solo para Recepcionista

    private String usuario;
    private String password;
}