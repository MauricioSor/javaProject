package com.v1.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;  // Ej: "MEDICO", "RECEPCIONISTA", etc.

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    // Getters y setters
}
