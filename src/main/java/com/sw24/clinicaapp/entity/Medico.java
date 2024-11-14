package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoPersona;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Medico extends Persona {
    private String matricula;
    private String especialidad;

    public Medico(String matricula, String especialidad) {
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    @Builder
    public Medico(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, EstadoPersona estadoPersona, String matricula, String especialidad) {
        super(dni, cuil, apellido, nombre, fechaNacimiento, direccion, localidad, provincia, pais, email, telefono, estadoPersona);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
}
