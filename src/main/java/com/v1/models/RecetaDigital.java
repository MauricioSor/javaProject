package com.v1.models;
import jakarta.persistence.*;

@Entity
@Table (name="Recetas_Digitales")
public class RecetaDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idRecetaDigital;

    public RecetaDigital() {
    }

    public RecetaDigital(int idRecetaDigital) {
        this.idRecetaDigital = idRecetaDigital;
    }

    public int getIdRecetaDigital() {
        return idRecetaDigital;
    }

    public void setIdRecetaDigital(int idRecetaDigital) {
        this.idRecetaDigital = idRecetaDigital;
    }

    
}
