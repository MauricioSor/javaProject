package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Asegúrate de usar IDENTITY para que Hibernate no intente generar la clave
    @Column(name = "id")  // La columna PK ahora se llama 'id'
    private Integer idHistoriaClinica;

    // Otros campos de la tabla 'historia_clinica'

    // Getters y setters
    public Integer getId() {
        return idHistoriaClinica;
    }

    public void setId(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }


}
