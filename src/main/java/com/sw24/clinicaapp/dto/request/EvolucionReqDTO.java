package com.sw24.clinicaapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvolucionReqDTO {
    private String texto;
    private Integer diagnosticoId;
    private String medicoDni;
    private PedidoLaboratorioReqDTO pedidoLaboratorio;
    private RecetaReqDTO receta;
}
