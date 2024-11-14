package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sw24.clinicaapp.enums.EstadoPersona;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "cuil", nullable = false)
    private String cuil;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Buenos_Aires")
    private Date fechaNacimiento;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String email;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private EstadoPersona estadoPersona;

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
