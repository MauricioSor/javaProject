package com.v1.consultorio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosticos")
public class Diagnosticos {
@Id
private int idDIAGNOSTICO;
private String nombre;
}
