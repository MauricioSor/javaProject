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

    @ManyToOne
    @JoinColumn(name = "idROL", referencedColumnName = "idRol", nullable = false)  // Ajusta esto según la columna correcta en la tabla de roles
    private Rol rol;

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    // Método para obtener idRol directamente
    public Integer getIdRol() {
        return (rol != null) ? rol.getIdRol() : null; // Devuelve el idRol de Rol si no es null
    }
}