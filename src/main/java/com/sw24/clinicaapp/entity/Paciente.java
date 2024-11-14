package com.sw24.clinicaapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sw24.clinicaapp.enums.EstadoPersona;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente extends Persona {
    private String pasaporte;
    private String obraSocial;
    private String nroAfiliado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historia_clinica_id")
    @JsonManagedReference
    @JsonIgnore
    private HistoriaClinica historiaClinica;

    @Builder
    public Paciente(
            String dni,
            String cuil,
            String apellido,
            String nombre,
            Date fechaNacimiento,
            String direccion,
            String localidad,
            String provincia,
            String pais,
            String email,
            String telefono,
            EstadoPersona estadoPersona,
            String pasaporte,
            String obraSocial,
            String nroAfiliado
    ) {
        super(
                dni,
                cuil,
                apellido,
                nombre,
                fechaNacimiento,
                direccion,
                localidad,
                provincia,
                pais,
                email,
                telefono,
                estadoPersona
        );
        this.pasaporte = pasaporte;
        this.obraSocial = obraSocial;
        this.nroAfiliado = nroAfiliado;
        this.historiaClinica = new HistoriaClinica(new Date());
    }
}