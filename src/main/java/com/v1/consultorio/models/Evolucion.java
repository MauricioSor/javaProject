package com.v1.consultorio.models;

import jakarta.persistence.*;
import jdk.jshell.Diag;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name ="evoluciones_clinicas")
public class Evolucion {
@Id
@Column(name = "idEvolucion")
private int idEvolucion;
private String texto;
private Date fecha;
private Date hora;
private String estadoEvolucion;

    @ManyToOne
    @JoinColumn(name = "fk_idDiagnostico", referencedColumnName = "idDiagnostico", nullable = false)
    private Diagnostico diagnostico;
    public int getIdEvolucion() {
        return idEvolucion;
    }

    public void setIdEvolucion(int idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getEstadoEvolucion() {
        return estadoEvolucion;
    }

    public void setEstadoEvolucion(String estadoEvolucion) {
        this.estadoEvolucion = estadoEvolucion;
    }
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
