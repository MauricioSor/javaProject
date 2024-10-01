package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nombre;
    private String dni;
    private String pasaporte;
    private String cuil;
    private String obraSocial;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

}
