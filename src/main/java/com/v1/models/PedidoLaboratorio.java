package com.v1.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PedidoLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoExamen;  // Hemograma, perfil lipídico, etc.

    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Relación con Médico
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    // Getters y setters
}
