package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;

    private String nombre;

    private String pasaporte;
    private String cuil;
    private String obraSocial;
    private boolean estado;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    // Relación con HistoriaClinica
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    private HistoriaClinica historiaClinica;

    // Getters y Setters

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean getEstado(){return this.estado;}
    public void setEstado(boolean estado){this.estado=estado;}
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}
