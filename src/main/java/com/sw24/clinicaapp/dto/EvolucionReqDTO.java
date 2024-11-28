package com.sw24.clinicaapp.dto;

import lombok.Getter;

@Getter
public class EvolucionReqDTO {
    private String informe;
    private String medicoDni;
    private PedidoLaboratorioReqDTO pedidoLaboratorio;
    private RecetaReqDTO receta;
}
