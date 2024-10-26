package com.v1.consultorio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {
    @Id
    private int idDiagnostico;
    private String nombre;

    public void setNombre(String nombre){this.nombre=nombre;}

    public String getNombre(){return this.nombre;}
    public void setIdDiagnostico(int idDiagnostico){this.idDiagnostico=idDiagnostico;}
    public int getIdDiagnostico(){return this.idDiagnostico;}
}