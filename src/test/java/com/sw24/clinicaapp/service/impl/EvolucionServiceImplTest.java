package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.request.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.response.EvolucionResDTO;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoEvolucion;
import com.sw24.clinicaapp.exception.BadRequestException;
import com.sw24.clinicaapp.exception.ResourceNotFoundException;
import com.sw24.clinicaapp.mapper.EvolucionMapper;
import com.sw24.clinicaapp.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EvolucionServiceImplTest {

    @Mock
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Mock
    private DiagnosticoRespository diagnosticoRespository;

    @Mock
    private MedicoRepository medicoRepository;

    @Mock
    private EvolucionRepository evolucionRepository;

    @Mock
    private EvolucionMapper evolucionMapper;

    @InjectMocks
    private EvolucionServiceImpl evolucionServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void crearEvolucionHistoriaClinicaIdEvolucionReqDTORetornaEvolucionResDTO() {
        // Datos de prueba
        Integer historiaClinicaId = 1;
        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO();
        evolucionReqDTO.setDiagnosticoId(1);
        evolucionReqDTO.setMedicoDni("12345678");
        evolucionReqDTO.setTexto("El paciente registra una temperatura de 37º");

        HistoriaClinica historiaClinica = new HistoriaClinica();
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setEvoluciones(new ArrayList<>());

        Medico medico = new Medico();
        Evolucion evolucion = new Evolucion();
        evolucion.setFecha(new Date());
        evolucion.setEstadoEvolucion(EstadoEvolucion.EDITABLE);

        when(historiaClinicaRepository.findById(historiaClinicaId)).thenReturn(Optional.of(historiaClinica));
        when(diagnosticoRespository.findById(evolucionReqDTO.getDiagnosticoId())).thenReturn(Optional.of(diagnostico));
        when(medicoRepository.findByDni(evolucionReqDTO.getMedicoDni())).thenReturn(Optional.of(medico));
        when(evolucionRepository.save(any(Evolucion.class))).thenReturn(evolucion);
        when(evolucionMapper.toEvolucionResDTO(any(Evolucion.class))).thenReturn(new EvolucionResDTO());

        // Llamada al metodo
        EvolucionResDTO result = evolucionServiceImpl.crearEvolucion(historiaClinicaId, evolucionReqDTO);

        // Verificaciones
        assertNotNull(result);
        verify(historiaClinicaRepository).findById(historiaClinicaId);
        verify(diagnosticoRespository).findById(evolucionReqDTO.getDiagnosticoId());
        verify(medicoRepository).findByDni(evolucionReqDTO.getMedicoDni());
        verify(evolucionRepository).save(any(Evolucion.class));
    }

    @Test
    public void crearEvolucionHistoriaClinicaIdInexistenteLanzaResourceNotFoundException() {
        // Datos de prueba
        Integer historiaClinicaId = 999; // Este ID es inexistente
        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO();
        evolucionReqDTO.setDiagnosticoId(1);
        evolucionReqDTO.setMedicoDni("12345678");
        evolucionReqDTO.setTexto("El paciente registra una temperatura de 37º");

        when(historiaClinicaRepository.findById(historiaClinicaId)).thenReturn(Optional.empty());

        // Verificación de excepción
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            evolucionServiceImpl.crearEvolucion(historiaClinicaId, evolucionReqDTO);
        });
        assertEquals("Historia Clinica no encontrada.", exception.getMessage());

        verify(historiaClinicaRepository).findById(historiaClinicaId);
        verify(diagnosticoRespository, never()).findById(anyInt());
        verify(medicoRepository, never()).findByDni(anyString());
        verify(evolucionRepository, never()).save(any(Evolucion.class));
    }

    @Test
    public void crearEvolucionEvolucionReqDTONullLanzaBadRequestException() {
        // Datos de prueba
        Integer historiaClinicaId = 1;
        HistoriaClinica historiaClinica = new HistoriaClinica();
        EvolucionReqDTO evolucionReqDTO = null; // Hacemos que EvolucionReqDTO sea null

        when(historiaClinicaRepository.findById(historiaClinicaId)).thenReturn(Optional.of(historiaClinica));

        // Verificación de excepción
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            evolucionServiceImpl.crearEvolucion(historiaClinicaId, evolucionReqDTO);
        });
        assertEquals("La evolución es obligatoria.", exception.getMessage());

        verify(historiaClinicaRepository, never()).findById(anyInt());
        verify(diagnosticoRespository, never()).findById(anyInt());
        verify(medicoRepository, never()).findByDni(anyString());
        verify(evolucionRepository, never()).save(any(Evolucion.class));
    }
}
