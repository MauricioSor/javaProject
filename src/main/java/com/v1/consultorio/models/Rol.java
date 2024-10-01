package com.v1.consultorio.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idRol;

        private String nombre;

        // Getters y Setters
        public Integer getIdRol() {
            return idRol;
        }

        public void setIdRol(Integer idRol) {
            this.idRol = idRol;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

}