package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoPersona;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
public class Paciente extends Persona {
    private String pasaporte;
    private String obraSocial;
    private String nroAfiliado;
    private HistoriaClinica historiaClinica;

    public Paciente() {}

    public Paciente(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, String pasaporte, String obraSocial, String nroAfiliado, EstadoPersona estadoPersona) {
        super(dni, cuil, apellido, nombre, fechaNacimiento, direccion, localidad, provincia, pais, email, telefono, estadoPersona);
        this.pasaporte = pasaporte;
        this.obraSocial = obraSocial;
        this.nroAfiliado = nroAfiliado;
        this.historiaClinica = new HistoriaClinica();
    }

    public void agregarEvolucion(UUID idDiagnostico, String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento, Integer dosis) {
        this.historiaClinica.agregarEvolucion(idDiagnostico, informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento, dosis);
    }

    public void agregarDiagnostico(String nombre) {
        historiaClinica.agregarDiagnostico(nombre);
    }
}