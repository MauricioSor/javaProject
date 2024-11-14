package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "diagnostico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Evolucion> evoluciones;

    @ManyToMany(mappedBy = "diagnosticos")
    @JsonBackReference
    private List<HistoriaClinica> historiasClinicas;

    public void agregarEvolucion(Evolucion evolucion) {
        evolucion.setDiagnostico(this);
        evoluciones.add(evolucion);
    }
}
