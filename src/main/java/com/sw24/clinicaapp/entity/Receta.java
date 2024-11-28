package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoReceta;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Getter
public class Receta {

    private UUID id;
    private String codigo;
    private String firma;
    private Integer dosis;
    private Date fecha;
    private Medicamento medicamento;
    private EstadoReceta estadoReceta;

    public Receta() {}

    public Receta(Medicamento medicamento, Integer dosis) {
        this.id = UUID.randomUUID();
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.fecha = new Date();
        this.codigo = generarCodigo();
        this.firma = "Firma del medico";
        this.estadoReceta = EstadoReceta.ACTIVO;
    }

    private String generarCodigo() {
        Random random = new Random();
        StringBuilder codigoBarras = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            codigoBarras.append(digit);
        }
        return codigoBarras.toString();
    }
}
