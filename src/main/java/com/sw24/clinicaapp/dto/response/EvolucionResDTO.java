package com.sw24.clinicaapp.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class EvolucionResDTO {
    private Integer id;
    private String texto;
    private Date fecha;
    private String estadoEvolucion;
    private MedicoResDTO medico;
    private PedidoLaboratorioResDTO pedidoLaboratorio;
    private RecetaResDTO receta;
}
