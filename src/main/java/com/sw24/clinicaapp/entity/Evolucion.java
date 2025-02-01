package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoEvolucion;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Evolucion {

    private UUID id;
    private String informe;
    private Date fecha;
    private Medico medico;
    private PedidoLaboratorio pedidoLaboratorio;
    private Receta receta;
    private EstadoEvolucion estadoEvolucion;

    public Evolucion() {
    }

    public Evolucion(String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        this.id = UUID.randomUUID();
        this.informe = informe;
        this.medico = medico;
        this.fecha = new Date();
        this.estadoEvolucion = EstadoEvolucion.EDITABLE;
        this.pedidoLaboratorio = (pedidoLabDescripcion != null && pedidoLabFecha != null) ? new PedidoLaboratorio(pedidoLabDescripcion, pedidoLabFecha) : null;
        this.receta = (medicamento != null) ? new Receta(medicamento) : null;
    }

    public boolean tiene(String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        boolean tieneInforme = this.informe != null && this.informe.equals(informe);
        boolean tieneMedico = this.medico != null && this.medico.equals(medico);
        boolean tienePedidoLab = this.pedidoLaboratorio == null
                ? pedidoLabDescripcion == null && pedidoLabFecha == null
                : this.pedidoLaboratorio.tiene(pedidoLabDescripcion, pedidoLabFecha);
        boolean tieneReceta = this.receta == null
                ? medicamento == null
                : this.receta.tiene(medicamento);

        return tieneInforme && tieneMedico && tienePedidoLab && tieneReceta;
    }
}
