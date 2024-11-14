package com.sw24.clinicaapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecetaReqDTO {
    private int dosis;
    private MedicamentoReqDTO medicamento;
}
