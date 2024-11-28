package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.dto.DiagnosticoReqDTO;
import com.sw24.clinicaapp.dto.PacienteReqDTO;
import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.exception.BadRequestException;
import com.sw24.clinicaapp.exception.ResourceNotFoundException;
import com.sw24.clinicaapp.repository.*;
import com.sw24.clinicaapp.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    RestTemplate restTemplate = new RestTemplate();
    private static String API_URL = "https://istp1service.azurewebsites.net/api/servicio-salud";


    public PacienteServiceImpl(PacienteRepository pacienteRepository, UsuarioRepository usuarioRepository) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Paciente crearPaciente(PacienteReqDTO pacienteReqDTO) {
        validarObraSocial(pacienteReqDTO.getObraSocial(), API_URL);

        Paciente paciente = new Paciente(
                pacienteReqDTO.getDni(),
                pacienteReqDTO.getCuil(),
                pacienteReqDTO.getApellido(),
                pacienteReqDTO.getNombre(),
                pacienteReqDTO.getFechaNacimiento(),
                pacienteReqDTO.getDireccion(),
                pacienteReqDTO.getLocalidad(),
                pacienteReqDTO.getProvincia(),
                pacienteReqDTO.getPais(),
                pacienteReqDTO.getEmail(),
                pacienteReqDTO.getTelefono(),
                pacienteReqDTO.getPasaporte(),
                pacienteReqDTO.getObraSocial(),
                pacienteReqDTO.getNroAfiliado(),
                EstadoPersona.ACTIVO
        );
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacientePorDni(String dniPaciente) {
        return pacienteRepository.findByDni(dniPaciente)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado."));
    }

    @Override
    public void agregarEvolucion(String dniPaciente, UUID idDiagnostico, EvolucionReqDTO evolucionReqDTO) {

        if (evolucionReqDTO == null) throw new BadRequestException("La evolución es obligatoria.");

        String pedidoLabDescripcion = null;
        Date pedidoLabFecha = null;
        Integer codigoMedicamento = null;
        Medicamento medicamento = null;
        Integer dosis = null;
        String informe = evolucionReqDTO.getInforme();

        Paciente paciente = pacienteRepository.findByDni(dniPaciente)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado."));
        Medico medico = (Medico) usuarioRepository.findByDni(evolucionReqDTO.getMedicoDni())
                .orElseThrow(() -> new ResourceNotFoundException("Medico no encontrado."))
                .getPersona();

        // Validar código de obra social
        validarObraSocial(paciente.getObraSocial(), API_URL);

        // Pedido de laboratorio
        if (evolucionReqDTO.getPedidoLaboratorio() != null) {
            pedidoLabDescripcion = evolucionReqDTO.getPedidoLaboratorio().getDescripcion();
            pedidoLabFecha = evolucionReqDTO.getPedidoLaboratorio().getFecha();
        }
        // Receta
        if (evolucionReqDTO.getReceta() != null) {
            codigoMedicamento = evolucionReqDTO.getReceta().getCodigoMedicamento();
            dosis = evolucionReqDTO.getReceta().getDosis();
            // Validar y obtener los datos del medicamento mediante la API externa
            medicamento = obtenerMedicamento(codigoMedicamento, API_URL);
        }
        paciente.agregarEvolucion(idDiagnostico, informe, medico, pedidoLabDescripcion, pedidoLabFecha, medicamento, dosis);
        pacienteRepository.save(paciente);
    }

    private void validarObraSocial(String codigoObraSocial, String API_URL) {
        String urlObraSocial;
        urlObraSocial = API_URL + "/obras-sociales/" + codigoObraSocial;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(urlObraSocial, String.class);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new BadRequestException("Código de obra social no válido.");
            }
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Código de obra social no válido.");
        }
    }

    private Medicamento obtenerMedicamento(Integer codigoMedicamento, String API_URL) {
        Medicamento medicamento;
        String urlMedicamentos = API_URL + "/medicamentos/" + codigoMedicamento;
        try {
            ResponseEntity<Medicamento> response = restTemplate.getForEntity(urlMedicamentos, Medicamento.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                medicamento = response.getBody();
            } else {
                throw new BadRequestException("Código de medicamento no arrojó resultados.");
            }
        } catch (HttpClientErrorException e) {
            throw new BadRequestException(e.getMessage());
        }
        return medicamento;
    }

    @Override
    public HistoriaClinica obtenerHistoriaClinica(String dni) {
        Paciente paciente = pacienteRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado."));
        return paciente.getHistoriaClinica();
    }

    @Override
    public void crearDiagnostico(String dni, DiagnosticoReqDTO diagnosticoDTO) {
        Paciente paciente = pacienteRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado."));
        paciente.agregarDiagnostico(diagnosticoDTO.getNombre());
        pacienteRepository.save(paciente);
    }
}