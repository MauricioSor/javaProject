package com.sw24.clinicaapp.dto.response;

import com.sw24.clinicaapp.entity.MedicamentoGenerico;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class MedicamentoResDTO {
    private Integer id;
    private String codigo;
    private String nombre;
    private String marca;
    private Date fechaVencimiento;
    private MedicamentoGenerico medicamentoGenerico;
}
