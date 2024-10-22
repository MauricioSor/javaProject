package com.v1.consultorio.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    @Column(name = "contraseña", nullable = false)
    private String contraseña;
    @Column(name = "mail", nullable = false)
    private String mail;
    // Almacena el rol como un string directamente
    @Column(name = "rol", nullable = false)
    private String rol;
    // Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public static class UsuarioResponse {
        private String nombre;
        private String rol;

        // Constructor
        public UsuarioResponse(String nombre, String rol) {
            this.nombre = nombre;
            this.rol = rol;
        }

        // Getters
        public String getNombre() {
            return nombre;
        }

        public String getRol() {
            return rol;
        }
    }
}