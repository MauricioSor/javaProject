package com.sw24.clinicaapp.dto;
import lombok.Getter;

import java.util.Date;

@Getter
public class PedidoLaboratorioReqDTO {
    private String descripcion;
    private Date fecha;

    public PedidoLaboratorioReqDTO() {
    }

    public PedidoLaboratorioReqDTO(String descripcion, Date fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
}
