package com.sw24.clinicaapp.entity;

import lombok.Getter;

@Getter
public class Medicamento {

    private Integer codigo;
    private String descripcion;
    private String formato;

    public Medicamento() {
    }

    public Medicamento(Integer codigo, String descripcion, String formato) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.formato = formato;
    }
}
