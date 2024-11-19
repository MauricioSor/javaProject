package com.sw24.clinicaapp.dto.response;

import com.sw24.clinicaapp.dto.DiagnosticoDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvolucionResDTO {
    private Integer id;
    private String texto;
    private Date fecha;
    private String estadoEvolucion;
    private MedicoResDTO medico;
    private PedidoLaboratorioResDTO pedidoLaboratorio;
    private RecetaResDTO receta;
    private DiagnosticoDTO diagnostico;
}
