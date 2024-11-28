package com.sw24.clinicaapp.entity;

import lombok.Getter;

@Getter
public class MedicamentoGenerico {
    private Integer codigo;
    private String nombre;

    public MedicamentoGenerico() {
    }

    public MedicamentoGenerico(String nombre) {
        this.nombre = nombre;
    }
}
