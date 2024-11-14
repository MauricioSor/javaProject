package com.sw24.clinicaapp.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PedidoLaboratorioReqDTO {
    private String descripcion;
    private Date fecha;
}
