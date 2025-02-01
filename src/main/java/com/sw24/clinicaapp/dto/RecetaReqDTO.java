package com.sw24.clinicaapp.dto;

import lombok.Getter;

@Getter
public class RecetaReqDTO {
    private Integer codigoMedicamento;

    public RecetaReqDTO() {
    }

    public RecetaReqDTO(Integer codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }
}
