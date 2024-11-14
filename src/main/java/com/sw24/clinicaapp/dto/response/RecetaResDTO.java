package com.sw24.clinicaapp.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class RecetaResDTO {
    private Integer id;
    private String codigo;
    private String firma;
    private int dosis;
    private Date fecha;
    private MedicamentoResDTO medicamento;
}
