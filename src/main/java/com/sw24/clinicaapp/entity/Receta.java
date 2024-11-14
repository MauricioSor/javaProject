package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sw24.clinicaapp.enums.EstadoReceta;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String firma;
    private int dosis;
    private Date fecha;

    @OneToOne
    @JsonBackReference
    private Evolucion evolucion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicamento_id", nullable = false)
    private Medicamento medicamento;

    @Enumerated(EnumType.STRING)
    private EstadoReceta estadoReceta;
}
