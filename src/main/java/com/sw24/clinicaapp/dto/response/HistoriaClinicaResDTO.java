package com.sw24.clinicaapp.dto.response;

import com.sw24.clinicaapp.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HistoriaClinicaResDTO {
    private Integer nroHistoriaClinica;
    private Date fechaCreacion;
    private Paciente paciente;
    private List<DiagnosticoResDTO> diagnosticos;
}