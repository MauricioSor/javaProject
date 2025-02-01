package com.sw24.clinicaapp.entity;

import com.sw24.clinicaapp.enums.EstadoPersona;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
public class Paciente extends Persona {
    private String pasaporte;
    private String codigoObraSocial;
    private String denominacionObraSocial;
    private String siglaObraSocial;

    private HistoriaClinica historiaClinica;

    public Paciente() {}

    public Paciente(String dni, String cuil, String apellido, String nombre, Date fechaNacimiento, String direccion, String localidad, String provincia, String pais, String email, String telefono, String pasaporte, String codigoObraSocial, String denominacionObraSocial, String siglaObraSocial, EstadoPersona estadoPersona) {
        super(dni, cuil, apellido, nombre, fechaNacimiento, direccion, localidad, provincia, pais, email, telefono, estadoPersona);
        this.pasaporte = pasaporte;
        this.codigoObraSocial = codigoObraSocial;
        this.denominacionObraSocial = denominacionObraSocial;
        this.siglaObraSocial = siglaObraSocial;
        this.historiaClinica = new HistoriaClinica();
    }

    public void agregarEvolucion(UUID idDiagnostico, String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        this.historiaClinica.agregarEvolucion(idDiagnostico, informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento);
    }

    public void agregarDiagnostico(String nombre) {
        this.historiaClinica.agregarDiagnostico(nombre);
    }

    public void agregarDiagnostico(UUID idDiagnostico,String nombre) {
        this.historiaClinica.agregarDiagnostico(idDiagnostico, nombre);
    }

    public boolean tieneEvolucion(UUID idDiagnosticoElegido, String informe, Medico medico, String pedidoLabDescripcion, Date pedidoLabFecha, Medicamento medicamento) {
        return this.historiaClinica.tieneEvolucion(idDiagnosticoElegido, informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento);
    }
}