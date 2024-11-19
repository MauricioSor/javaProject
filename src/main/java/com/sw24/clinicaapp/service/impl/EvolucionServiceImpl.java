package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.request.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.request.MedicamentoReqDTO;
import com.sw24.clinicaapp.dto.request.PedidoLaboratorioReqDTO;
import com.sw24.clinicaapp.dto.request.RecetaReqDTO;
import com.sw24.clinicaapp.dto.response.*;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoEvolucion;
import com.sw24.clinicaapp.enums.EstadoReceta;
import com.sw24.clinicaapp.exception.BadRequestException;
import com.sw24.clinicaapp.exception.ResourceNotFoundException;
import com.sw24.clinicaapp.mapper.EvolucionMapper;
import com.sw24.clinicaapp.repository.*;
import com.sw24.clinicaapp.service.EvolucionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EvolucionServiceImpl implements EvolucionService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final DiagnosticoRespository diagnosticoRespository;
    private final MedicoRepository medicoRepository;
    private final EvolucionRepository evolucionRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final EvolucionMapper evolucionMapper = EvolucionMapper.INSTANCE;

    public EvolucionServiceImpl(HistoriaClinicaRepository historiaClinicaRepository, DiagnosticoRespository diagnosticoRespository, MedicoRepository medicoRepository, EvolucionRepository evolucionRepository, MedicamentoRepository medicamentoRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.diagnosticoRespository = diagnosticoRespository;
        this.medicoRepository = medicoRepository;
        this.evolucionRepository = evolucionRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public EvolucionResDTO crearEvolucion(Integer historiaClinicaId, EvolucionReqDTO evolucionReqDTO) {

        if (evolucionReqDTO == null) {
            throw new BadRequestException("La evolución es obligatoria.");
        }

        HistoriaClinica historiaClinica = historiaClinicaRepository.findById(historiaClinicaId)
                .orElseThrow(() -> new ResourceNotFoundException("Historia Clinica no encontrada."));
        Diagnostico diagnostico = diagnosticoRespository.findById(evolucionReqDTO.getDiagnosticoId())
                .orElseThrow(() -> new ResourceNotFoundException("Diagnostico no encontrado."));
        Medico medico = medicoRepository.findByDni(evolucionReqDTO.getMedicoDni())
                .orElseThrow(() -> new ResourceNotFoundException("Medico no encontrado."));

        Evolucion evolucion = Evolucion.builder()
                .historiaClinica(historiaClinica)
                .texto(evolucionReqDTO.getTexto())
                .fecha(new Date())
                .medico(medico)
                .estadoEvolucion(EstadoEvolucion.EDITABLE)
                .build();

        PedidoLaboratorioReqDTO pedidoLaboratorioDTO = evolucionReqDTO.getPedidoLaboratorio();
        if (pedidoLaboratorioDTO != null) {
            PedidoLaboratorio pedidoLaboratorio = PedidoLaboratorio.builder()
                    .descripcion(pedidoLaboratorioDTO.getDescripcion())
                    .fecha(pedidoLaboratorioDTO.getFecha())
                    .build();
            evolucion.agregarPedidoLaboratorio(pedidoLaboratorio);
        }

        RecetaReqDTO recetaDTO = evolucionReqDTO.getReceta();
        if (recetaDTO != null) {
            MedicamentoReqDTO medicamentoDTO = recetaDTO.getMedicamento();
            if (medicamentoDTO != null) {
                Medicamento medicamento = medicamentoRepository.findByCodigo(medicamentoDTO.getCodigo())
                        .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado."));

                Receta receta = Receta.builder()
                        .codigo(evolucion.crearCodigoReceta())
                        .firma(evolucion.firmarReceta(medico))
                        .dosis(recetaDTO.getDosis())
                        .fecha(new Date())
                        .medicamento(medicamento)
                        .estadoReceta(EstadoReceta.ACTIVO)
                        .build();

                evolucion.agregarReceta(receta);
            } else {
                throw new BadRequestException("El Medicamento es obligatorio en la receta.");
            }
        }

        diagnostico.agregarEvolucion(evolucion);

        if (!historiaClinica.getDiagnosticos().contains(diagnostico)) {
            historiaClinica.agregarDiagnostico(diagnostico);
        }

        evolucion = evolucionRepository.save(evolucion);

        return evolucionMapper.toEvolucionResDTO(evolucion);
    }
}
