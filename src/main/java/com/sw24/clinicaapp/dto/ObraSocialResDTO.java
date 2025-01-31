package com.sw24.clinicaapp.dto;

import lombok.Getter;

@Getter
public class ObraSocialResDTO {
    private String codigo;
    private String denominacion;
    private String sigla;

    public ObraSocialResDTO(String codigo, String denominacion, String sigla) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.sigla = sigla;
    }
}
