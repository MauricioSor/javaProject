package com.v1.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String matriculaNacional;
    private String especialidad;
    private String email;

    // Relaciones
    @OneToMany(mappedBy = "medico")
    private List<HistoriaClinica> historiasClinicas;

    @OneToMany(mappedBy = "medico")
    private List<Receta> recetas;

    // Getters y setters
}
