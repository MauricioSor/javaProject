package com.sw24.clinicaapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MedicoDTO {
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
    private String matricula;
    private String especialidad;

    private String usuario;
    private String password;
}
