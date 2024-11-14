package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sw24.clinicaapp.enums.EstadoEvolucion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Evolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "texto", nullable = false)
    private String texto;

    private Date fecha;

    @Enumerated(EnumType.STRING)
    private EstadoEvolucion estadoEvolucion;

    @ManyToOne
    @JoinColumn(name = "diagnostico_id", nullable = false)
    @JsonBackReference
    private Diagnostico diagnostico;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    @JsonIgnore
    private HistoriaClinica historiaClinica;

    @OneToOne(mappedBy = "evolucion", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private PedidoLaboratorio pedidoLaboratorio;

    @OneToOne(mappedBy = "evolucion", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Receta receta;

    public Evolucion() {
        this.fecha = new Date();
    }

    public void agregarPedidoLaboratorio(PedidoLaboratorio pedidoLaboratorio) {
        pedidoLaboratorio.setEvolucion(this);
        this.pedidoLaboratorio = pedidoLaboratorio;
    }

    public void agregarReceta(Receta receta) {
        receta.setEvolucion(this);
        this.receta = receta;
    }

    public String firmarReceta(Medico medico) {
        return "Firmado por: " + medico.getNombre() + " " + medico.getApellido();
    }

    public String crearCodigoReceta() {
        Random random = new Random();
        StringBuilder codigoBarras = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            codigoBarras.append(digit);
        }
        return codigoBarras.toString();
    }
}
