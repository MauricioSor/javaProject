package com.v1.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="Recetas_Digitales")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    private String medicamentoComercial;
    private String medicamentoGenerico;
    private String diagnostico;
    private String firmaElectronica;
    private String codigoBarra;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Relación con Médico
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
