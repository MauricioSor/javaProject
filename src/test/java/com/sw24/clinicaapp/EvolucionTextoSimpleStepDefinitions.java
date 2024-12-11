package com.sw24.clinicaapp;

import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.PedidoLaboratorioReqDTO;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.*;
import com.sw24.clinicaapp.service.PacienteService;
import com.sw24.clinicaapp.service.impl.PacienteServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EvolucionTextoSimpleStepDefinitions {

    private Paciente paciente;
    private String dniPaciente;
    private String informe;
    private UUID idDiagnosticoElegido;
    private String pedLaboratorioDescripcion;
    private Date pedLaboratorioFecha;

    private Date fechaNacimiento;

    private String dniMedico;
    private Usuario<Persona> usuarioMedico;

    private PacienteService pacienteService;
    private PacienteRepository pacienteRepository;
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    private PedidoLaboratorioReqDTO pedidoLaboratorioReqDTO;


    @Before
    public void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        pacienteRepository = mock(PacienteRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);

        pacienteService = new PacienteServiceImpl(pacienteRepository, usuarioRepository);

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
    }

    @Given("el medico {string} {string} que ha iniciado sesion")
    public void elMedicoQueHaIniciadoSesion(String nombreMedico, String apellidoMedico) throws ParseException {
        this.fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse("08-01-1970");
        String usuario = "marcelo.perez";
        String password = "password123";

        Medico medico = new Medico(
                "16523950",
                "27-16523950-1",
                apellidoMedico,
                nombreMedico,
                this.fechaNacimiento,
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

        this.usuarioMedico = new Usuario<>(medico, usuario, passwordEncoder.encode(password));
        when(usuarioRepository.findByDni(anyString())).thenReturn(Optional.of(this.usuarioMedico));
    }

    @And("ha buscado la historia clinica del paciente {string} que posee los siguientes diagnostivos previos:")
    public void haBuscadoLaHistoriaClinicaDelPacienteQuePoseeLosSiguientesDiagnostivosPrevios(String dniPaciente, DataTable diagnosticosPrevios) throws ParseException {
        this.dniPaciente = dniPaciente;
        Map<String, String> diagnosticos = diagnosticosPrevios.asMap(String.class, String.class);
        this.fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse("05-06-1990");

        this.paciente = new Paciente(
                this.dniPaciente,
                "20-20230234-7",
                "Diaz",
                "Juan",
                this.fechaNacimiento,
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

        diagnosticos.forEach((idDiagnostico, nombreDiagnostico) -> {
            this.paciente.agregarDiagnostico(UUID.fromString(idDiagnostico), nombreDiagnostico);
        });

        when(pacienteRepository.findByDni(this.dniPaciente)).thenReturn(Optional.of(this.paciente));
        assertThat(pacienteService.buscarPacientePorDni(this.dniPaciente)).isEqualTo(this.paciente);
        verify(pacienteRepository, times(1)).findByDni(this.dniPaciente);
    }

    @When("el medico redacta para el paciente un informe en la evolucion para el diagnostico {string} eh indica en el mismo {string}")
    public void elMedicoRedactaParaElPacienteUnInformeEnLaEvolucionParaElDiagnosticoEhIndicaEnElMismo(String idDiagnosticoElegido, String informe) {
        this.informe = informe;
        this.idDiagnosticoElegido = UUID.fromString(idDiagnosticoElegido);
        this.dniMedico = this.usuarioMedico.getPersona().getDni();
    }

    @And("el medico guarda la evolucion")
    public void elMedicoGuardaLaEvolucion() {
        EvolucionReqDTO evolucionReqDTO = new EvolucionReqDTO(this.informe, this.dniMedico, this.pedidoLaboratorioReqDTO, null);
        pacienteService.agregarEvolucion(this.dniPaciente, this.idDiagnosticoElegido, evolucionReqDTO);
    }

    @Then("se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe y el medico.")
    public void seRegistraLaEvolucionEnLaHistoriaClinicaDelPacienteConElDiagnosticoElInformeYElMedico() {
        verify(pacienteRepository, times(2)).findByDni(this.dniPaciente);
        verify(usuarioRepository, times(1)).findByDni(this.dniMedico);
        verify(pacienteRepository, times(1)).save(this.paciente);
        assertThat(this.paciente.tieneEvolucion(this.idDiagnosticoElegido, this.informe, (Medico) this.usuarioMedico.getPersona(), null, null, null)).isTrue();
    }

    @And("agrega un pedido de laboratorio solicitando un {string} con fecha {string} para el paciente")
    public void agregaUnPedidoDeLaboratorioSolicitandoUnParaElPaciente(String pedLaboratorioDescripcion, String pedLaboratorioFecha) throws ParseException {
        this.pedLaboratorioDescripcion = pedLaboratorioDescripcion;
        this.pedLaboratorioFecha = new SimpleDateFormat("dd/MM/yyyy").parse(pedLaboratorioFecha);
        this.pedidoLaboratorioReqDTO = new PedidoLaboratorioReqDTO(this.pedLaboratorioDescripcion, this.pedLaboratorioFecha);
    }

    @Then("se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe, el pedido de laboratorio y el medico.")
    public void seRegistraLaEvolucionEnLaHistoriaClinicaDelPacienteConElDiagnosticoElInformeElPedidoDeLaboratorioYElMedico() {
        verify(pacienteRepository, times(2)).findByDni(this.dniPaciente);
        verify(usuarioRepository, times(1)).findByDni(this.dniMedico);
        verify(pacienteRepository, times(1)).save(this.paciente);
        assertThat(this.paciente.tieneEvolucion(this.idDiagnosticoElegido, this.informe, (Medico) this.usuarioMedico.getPersona(), this.pedLaboratorioDescripcion, this.pedLaboratorioFecha, null)).isTrue();
    }
}