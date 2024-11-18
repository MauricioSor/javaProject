package com.sw24.clinicaapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EvolucionReqDTO {
    private String texto;
    private Integer diagnosticoId;
    private String medicoDni;
    private PedidoLaboratorioReqDTO pedidoLaboratorio;
    private RecetaReqDTO receta;
}
