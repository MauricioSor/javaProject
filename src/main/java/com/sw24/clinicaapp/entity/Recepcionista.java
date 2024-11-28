package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoPersona;
import lombok.*;

import java.util.Date;

@Getter
public class Recepcionista extends Persona {
    private String legajo;

    public Recepcionista() {}

    public Recepcionista(String legajo) {
        this.legajo = legajo;
    }

    public Recepcionista(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, String legajo, EstadoPersona estadoPersona) {
        super(dni, cuil, apellido, nombre, fechaNacimiento, direccion, localidad, provincia, pais, email, telefono, estadoPersona);
        this.legajo = legajo;
    }
}
