package com.v1.consultorio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name ="evoluciones_clinicas")
public class Evolucion {
@Id
@Column(name = "idEVOLUCION")
private int idEvolucion;
        private String texto;
private Date fecha;
private Date hora;
    @Column(name = "estadoEvolucion")
    private boolean estadoEvolucion;
}
