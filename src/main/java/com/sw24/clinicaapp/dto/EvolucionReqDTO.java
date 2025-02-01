package com.sw24.clinicaapp.dto;

import lombok.Getter;

@Getter
public class EvolucionReqDTO {
    private String informe;
    private String medicoDni;
    private PedidoLaboratorioReqDTO pedidoLaboratorio;
    private RecetaReqDTO receta;

    public EvolucionReqDTO(String informe, String medicoDni, PedidoLaboratorioReqDTO pedidoLaboratorio, RecetaReqDTO receta) {
        this.informe = informe;
        this.medicoDni = medicoDni;
        this.pedidoLaboratorio = pedidoLaboratorio;
        this.receta = receta;
    }
}