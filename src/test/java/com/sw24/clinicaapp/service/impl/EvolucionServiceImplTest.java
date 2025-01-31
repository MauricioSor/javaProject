package com.sw24.clinicaapp.service.impl;

import com.sw24.clinicaapp.client.ApiExternaClient;
import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.PedidoLaboratorioReqDTO;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.exception.ResourceNotFoundException;
import com.sw24.clinicaapp.repository.*;
import com.sw24.clinicaapp.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EvolucionServiceImplTest {

    UsuarioRepository usuarioRepository;
    PacienteRepository pacienteRepository;

    PacienteService pacienteService;
    ApiExternaClient apiExternaClient;
    PasswordEncoder passwordEncoder;

    Paciente paciente;
    Medico medico;
    Usuario<Persona> usuarioMedico;

    @BeforeEach
    void setUp() {
        this.usuarioRepository = mock(UsuarioRepository.class);
        this.pacienteRepository = mock(PacienteRepository.class);
        this.passwordEncoder = mock(PasswordEncoder.class);
        this.apiExternaClient = mock(ApiExternaClient.class);

        this.pacienteService = new PacienteServiceImpl(pacienteRepository, usuarioRepository, apiExternaClient);

        this.paciente = new Paciente(
                "30265408",
                "20-30265408-7",
                "Diaz",
                "Juan",
                new Date(),
                "Rivadavia 1075",
                "San Miguel de Tucuman",
                "Tucuman",
                "Argentina",
                "juan@gmail.com",
                "+54381302632",
                "AR-20181840",
                "127000",
                "OBRA SOCIAL DE TRABAJADORES DE ESTACIONES DE SERVICIO",
                "OSTES",
                EstadoPersona.ACTIVO
        );

        this.paciente.agregarDiagnostico(UUID.fromString("b838c621-f853-400b-b7da-226bbf83d026"), "Dengue");
        this.paciente.agregarDiagnostico(UUID.fromString("b149f5c7-2a84-465c-b848-a41348a2fc20"), "COVID");

        this.medico = new Medico(
                "16523950",
                "27-16523950-1",
                "Perez",
                "Pedro",
                new Date(),
                "9 de Julio 230",
                "San Miguel de Tucuman",
                "Tucuman",
                "Argentina",
                "email-prueba@gmail.com",
                "+543816320145",
                "mat-123",
                "Cardiologia",
                EstadoPersona.ACTIVO
        );

        this.usuarioMedico = new Usuario<>(this.medico, "medicoUser", passwordEncoder.encode("123456"));

        when(usuarioRepository.findByDni("12345678")).thenReturn(Optional.of(this.usuarioMedico));
        when(pacienteRepository.findByDni("30265408")).thenReturn(Optional.of(this.paciente));
    }

    @Test
    public void agregarEvolucionTextoSimpleDniPacienteInexistenteLanzaResourceNotFoundException() {

        // Datos de prueba
        String dniPacienteReq = "20305693"; // Dni paciente inexistente
        UUID idDiagnosticoReq = UUID.fromString("b838c621-f853-400b-b7da-226bbf83d026");
        String informeReq = "El paciente registra una temperatura de 37º";
        String dniMedicoReq = "12345678";

        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO(informeReq, dniMedicoReq, null, null);

        // Ejecución y Verificaciones
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            pacienteService.agregarEvolucion(dniPacienteReq, idDiagnosticoReq, evolucionReqDTO);
        });
        verify(pacienteRepository, times(1)).findByDni(dniPacienteReq);
        verify(usuarioRepository, times(0)).findByDni(dniMedicoReq);
        verify(pacienteRepository, times(0)).save(this.paciente);
        assertThat(exception.getMessage()).isEqualTo("Paciente no encontrado.");
    }

    @Test
    public void agregarEvolucionIdDiagnosticoInexistenteLanzaResourceNotFoundException() {
        // Datos de prueba
        String dniPacienteReq = "30265408";
        UUID idDiagnosticoReq = UUID.fromString("39d5d4da-aba2-4cba-badc-1b3afe8bde30"); // Id diagnóstico inexistente
        String informeReq = "El paciente registra una temperatura de 37º";
        String dniMedicoReq = "12345678";

        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO(informeReq, dniMedicoReq, null, null);

        // Ejecución y Verificaciones
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
           pacienteService.agregarEvolucion(dniPacienteReq, idDiagnosticoReq, evolucionReqDTO);
        });
        verify(pacienteRepository, times(1)).findByDni(dniPacienteReq);
        verify(usuarioRepository, times(1)).findByDni(dniMedicoReq);
        verify(pacienteRepository, times(0)).save(this.paciente);
        assertThat(exception.getMessage()).isEqualTo("No se encontro el diagnostico con id " + idDiagnosticoReq);
    }

    @Test
    public void agregarEvolucionReqDTODatosCorrectos() {
        // Datos de prueba
        String dniPacienteReq = "30265408"; // Dni paciente correcto
        UUID idDiagnosticoReq = UUID.fromString("b838c621-f853-400b-b7da-226bbf83d026"); // Id diagnóstico correcto
        String informeReq = "El paciente registra una temperatura de 37º";
        String dniMedicoReq = "12345678"; // Dni médico correcto

        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO(informeReq, dniMedicoReq, null, null);

        // Ejecución
        pacienteService.agregarEvolucion(dniPacienteReq, idDiagnosticoReq, evolucionReqDTO);

        // Verificaciones
        verify(pacienteRepository, times(1)).findByDni(dniPacienteReq);
        verify(usuarioRepository, times(1)).findByDni(dniMedicoReq);
        verify(pacienteRepository, times(1)).save(this.paciente);
        assertThat(this.paciente.tieneEvolucion(idDiagnosticoReq, informeReq, this.medico, null, null, null)).isTrue();
    }

    @Test
    public void agregarEvolucionConPedidoLaboratorioReqDTODatosCorrectos() throws ParseException {
        // Datos de prueba
        String dniPacienteReq = "30265408"; // Dni paciente correcto
        UUID idDiagnosticoReq = UUID.fromString("b838c621-f853-400b-b7da-226bbf83d026"); // Id diagnóstico correcto
        String informeReq = "El paciente registra una temperatura de 37º";
        String dniMedicoReq = "12345678"; // Dni médico correcto
        String pedidoLabDescripcionReq = "Se solicita un análsis de sangre";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date pedidoLabFechaReq = formatter.parse("2024-12-15");

        PedidoLaboratorioReqDTO pedidoLaboratorioReqDTO = new PedidoLaboratorioReqDTO(pedidoLabDescripcionReq, pedidoLabFechaReq);
        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO(informeReq, dniMedicoReq, pedidoLaboratorioReqDTO, null);

        // Ejecución
        pacienteService.agregarEvolucion(dniPacienteReq, idDiagnosticoReq, evolucionReqDTO);

        // Verificaciones
        verify(pacienteRepository, times(1)).findByDni(dniPacienteReq);
        verify(usuarioRepository, times(1)).findByDni(dniMedicoReq);
        verify(pacienteRepository, times(1)).save(this.paciente);
        assertThat(this.paciente.tieneEvolucion(idDiagnosticoReq, informeReq, this.medico, pedidoLabDescripcionReq, pedidoLabFechaReq, null)).isTrue();
    }
}
