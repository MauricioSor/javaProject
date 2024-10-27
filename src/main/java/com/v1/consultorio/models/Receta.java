package com.v1.consultorio.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name="recetas_digitales")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idReceta_digital;
        private Boolean estado;
        private String medicamentoGenerico;
        private String codigoBarra;
    // Getter y Setter para idReceta_digital
    public int getIdReceta_digital() {
        return idReceta_digital;
    }

    public void setIdReceta_digital(int idReceta_digital) {
        this.idReceta_digital = idReceta_digital;
    }

    // Getter y Setter para estado
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Getter y Setter para medicamentoGenerico
    public String getMedicamentoGenerico() {
        return medicamentoGenerico;
    }

    public void setMedicamentoGenerico(String medicamentoGenerico) {
        this.medicamentoGenerico = medicamentoGenerico;
    }

    // Getter y Setter para codigoBarra
    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
