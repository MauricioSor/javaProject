package com.sw24.clinicaapp.service;

import com.sw24.clinicaapp.dto.request.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.response.EvolucionResDTO;
import com.sw24.clinicaapp.entity.Evolucion;

public interface EvolucionService {
    EvolucionResDTO crearEvolucion(Integer historiaClinicaId, EvolucionReqDTO evolucionReqDTO);
}
