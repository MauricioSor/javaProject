package com.sw24.clinicaapp.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PedidoLaboratorioResDTO {
    private Integer codigo;
    private String descripcion;
    private Date fecha;
}
