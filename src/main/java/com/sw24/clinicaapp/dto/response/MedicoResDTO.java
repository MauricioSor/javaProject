package com.sw24.clinicaapp.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MedicoResDTO {
    private String dni;
    private String matricula;
    private String especialidad;
    private String apellido;
    private String nombre;
}
