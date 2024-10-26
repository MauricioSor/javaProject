package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistoriaClinica {

    @Id
    private Integer idHistoriaClinica;
    private Date fechaCreacion;
    // Getters y setters
    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }
    public void setFechaCreacion(Date fechaCreacion){this.fechaCreacion=fechaCreacion;}
    public Date getFechaCreacion(){return fechaCreacion;}

}
