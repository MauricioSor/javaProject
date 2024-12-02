package com.sw24.clinicaapp.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
public class Diagnostico {

    private UUID id;
    private String nombre;
    private List<Evolucion> evoluciones;

    public Diagnostico() {
    }

    public Diagnostico(String nombre) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.evoluciones = new ArrayList<>();
    }

    public void agregarEvolucion(String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        Evolucion evolucion = new Evolucion(informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento);
        evoluciones.add(evolucion);
    }
}
