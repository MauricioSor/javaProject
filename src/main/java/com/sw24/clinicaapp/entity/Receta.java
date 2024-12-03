package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoReceta;
import lombok.*;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Getter
public class Receta {

    private UUID id;
    private String codigo;
    private String firma;
    private Date fecha;
    private Medicamento medicamento;
    private EstadoReceta estadoReceta;

    public Receta() {}

    public Receta(Medicamento medicamento) {
        this.id = UUID.randomUUID();
        this.medicamento = medicamento;
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

    public boolean tiene(Medicamento medicamento) {
        return this.medicamento.equals(medicamento);
    }
}
