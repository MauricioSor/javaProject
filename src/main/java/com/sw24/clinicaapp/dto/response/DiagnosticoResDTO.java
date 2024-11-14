package com.sw24.clinicaapp.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiagnosticoResDTO {
    private Integer id;
    private String codigo;
    private String nombre;
    private List<EvolucionResDTO> evoluciones;
}
