package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.exception.ResourceNotFoundException;
import lombok.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class HistoriaClinica {

    private Integer nroHistoriaClinica;
    private Date fechaCreacion;
    private List<Diagnostico> diagnosticos;
    private static final AtomicInteger contadorHistoriaClinica = new AtomicInteger(1000);

    public HistoriaClinica() {
        this.nroHistoriaClinica = contadorHistoriaClinica.incrementAndGet();
        this.fechaCreacion = new Date();
        this.diagnosticos = new ArrayList<>();
    }

    public void agregarEvolucion(UUID idDiagnostico, String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        Diagnostico diagnostico = diagnosticos.stream().filter(d -> d.getId().equals(idDiagnostico))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el diagnostico con id " + idDiagnostico));
        diagnostico.agregarEvolucion(informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento);
    }

    public void agregarDiagnostico(String nombre) {
        Diagnostico diagnostico = new Diagnostico(nombre);
        diagnosticos.add(diagnostico);
    }
}
