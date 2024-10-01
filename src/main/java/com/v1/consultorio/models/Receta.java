package com.v1.consultorio.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="recetas_digitales")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta_digital;


    private String estado;
    private String medicamentoGenerico;
    private String codigoBarra;

}
