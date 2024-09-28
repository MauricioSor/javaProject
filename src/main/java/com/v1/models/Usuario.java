package com.v1.models;
import jakarta.persistence.*;

@Entity
@Table (name="usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String contraseña;

    // Getters y setters
}
