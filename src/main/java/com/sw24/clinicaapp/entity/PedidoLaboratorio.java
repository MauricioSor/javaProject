package com.sw24.clinicaapp.entity;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
public class PedidoLaboratorio {

    private UUID id;
    private String descripcion;
    private Date fecha;

    public PedidoLaboratorio() {}

    public PedidoLaboratorio(String descripcion, Date fecha) {
        this.id = UUID.randomUUID();
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public boolean tiene(String pedidoLabDescripcion, Date pedidoLabFecha) {
        return this.descripcion.equals(pedidoLabDescripcion) && this.fecha.equals(pedidoLabFecha);
    }
}
