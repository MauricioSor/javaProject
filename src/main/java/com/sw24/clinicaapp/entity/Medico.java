package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoPersona;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
public class Medico extends Persona {
    private String matricula;
    private String especialidad;

    public Medico() {}

    public Medico(String matricula, String especialidad) {
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    public Medico(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, String matricula, String especialidad, EstadoPersona estadoPersona) {
        super(dni, cuil, apellido, nombre, fechaNacimiento, direccion, localidad, provincia, pais, email, telefono, estadoPersona);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(matricula, medico.matricula) && Objects.equals(especialidad, medico.especialidad);
    }
}
