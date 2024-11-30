package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sw24.clinicaapp.enums.EstadoPersona;
import lombok.*;

import java.util.Date;

@Getter
public class Persona {

    private String dni;
    private String cuil;
    private String apellido;
    private String nombre;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String email;
    private String telefono;
    private EstadoPersona estadoPersona;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Buenos_Aires")
    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, EstadoPersona estadoPersona) {
        this.dni = dni;
        this.cuil = cuil;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.email = email;
        this.telefono = telefono;
        this.estadoPersona = estadoPersona;
    }
}
