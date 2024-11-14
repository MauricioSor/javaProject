package com.sw24.clinicaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "marca", nullable = false)
    private String marca;
    private Date fechaVencimiento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicamento_generico_id", nullable = false)
    private MedicamentoGenerico medicamentoGenerico;

}
