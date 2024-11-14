package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.MedicoDTO;
import com.sw24.clinicaapp.entity.Medico;

public interface MedicoService {
    Medico crearMedico(MedicoDTO medicoDTO);
}
