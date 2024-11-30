package com.sw24.clinicaapp.dto;
import lombok.Getter;

import java.util.Date;

@Getter
public class PedidoLaboratorioReqDTO {
    private String descripcion;
    private Date fecha;
}
