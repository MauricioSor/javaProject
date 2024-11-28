import com.sw24.clinicaapp.dto.EvolucionReqDTO;
import com.sw24.clinicaapp.dto.PedidoLaboratorioReqDTO;
//import com.sw24.clinicaapp.dto.response.EvolucionResDTO;
import com.sw24.clinicaapp.entity.*;
import com.sw24.clinicaapp.enums.EstadoPersona;
import com.sw24.clinicaapp.repository.*;
import com.sw24.clinicaapp.service.UsuarioService;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class EvolucionTextoSimpleStepDefinitions {

    /*

    private Medico medico;
    private Usuario<Persona> usuarioMedico;
    private Paciente paciente;
    private String dniPaciente;
    private Integer nroHistoriaClinica;
    private HistoriaClinica historiaClinica;
    private List<Diagnostico> diagnosticos;
    private String informe;
    private Diagnostico diagnosticoElegido;
    private String textoPedidoLaboratorio;
    private Date fechaPedidoLaboratorio;
    private Evolucion evolucion;

    private EvolucionReqDTO evolucionReqDTO;
    private EvolucionResDTO evolucionResDTO;
    private PedidoLaboratorioReqDTO pedidoLaboratorioReqDTO;

    private PacienteRepository pacienteRepository;
    private EvolucionRepository evolucionRepository;
    private HistoriaClinicaRepository historiaClinicaRepository;
    private DiagnosticoRespository diagnosticoRespository;
    private MedicoRepository medicoRepository;
    private MedicamentoRepository medicamentoRepository;

    private EvolucionService evolucionService;
    private UsuarioService usuarioService;


     */

    @Before
    public void setUp() {

        /*

        this.diagnosticos = new ArrayList<>();

        historiaClinicaRepository = mock(HistoriaClinicaRepository.class);
        diagnosticoRespository = mock(DiagnosticoRespository.class);
        medicoRepository = mock(MedicoRepository.class);
        medicamentoRepository = mock(MedicamentoRepository.class);
        evolucionRepository = mock(EvolucionRepository.class);
        usuarioService = mock(UsuarioService.class);
        pacienteRepository = mock(PacienteRepository.class);

        this.evolucionService = new EvolucionServiceImpl(historiaClinicaRepository, diagnosticoRespository, medicoRepository, evolucionRepository, medicamentoRepository);

         */
    }

    @Given("el medico {string} {string} que ha iniciado sesion con usuario {string} y password {string}")
    public void elMedicoQueHaIniciadoSesion(String nombreMedico, String apellidoMedico, String usuario, String password) throws ParseException {

        /*

        medico = Medico.builder()
                .dni("16523950")
                .cuil("27-16523950-1")
                .apellido(apellidoMedico)
                .nombre(nombreMedico)
                .fechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("08-01-1970"))
                .direccion("9 de Julio 230")
                .localidad("San Miguel de Tucuman")
                .provincia("Tucuman")
                .pais("Argentina")
                .email("marceloperez@gmail.com")
                .telefono("+543816320145")
                .estadoPersona(EstadoPersona.ACTIVO)
                .build();

        usuarioMedico = new Usuario<>(medico, usuario, password);
        when(usuarioService.iniciarSesion(usuario, password)).thenReturn(usuarioMedico);
        when(medicoRepository.findByDni(medico.getDni())).thenReturn(Optional.of(medico));

         */
    }

    @And("ha buscado la historia clinica del paciente {string} que posee los siguientes diagnostivos previos:")
    public void haBuscadoLaHistoriaClinicaDelPacienteQuePoseeLosSiguientesDiagnostivosPrevios(String dniPaciente, List<String> diagnosticosPrevios) throws ParseException {

        /*

        this.dniPaciente = dniPaciente;

        paciente = Paciente.builder()
                .dni(this.dniPaciente)
                .cuil("20-20230234-7")
                .apellido("Diaz")
                .nombre("Juan")
                .fechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("05-06-1990"))
                .direccion("Rivadavia 1075")
                .localidad("San Miguel de Tucuman")
                .provincia("Tucuman")
                .pais("Argentina")
                .email("juan@gmail.com")
                .telefono("+54381302632")
                .estadoPersona(EstadoPersona.ACTIVO)
                .pasaporte("AR-20181840")
                .obraSocial("Osde")
                .nroAfiliado("20151980")
                .build();

        historiaClinica = new HistoriaClinica();
        historiaClinica.setNroHistoriaClinica(123456);
        historiaClinica.setPaciente(paciente);
        paciente.setHistoriaClinica(historiaClinica);

        diagnosticos.addAll(diagnosticosPrevios.stream()
                .map(nombreDiagnostico -> Diagnostico.builder()
                        .id(diagnosticos.size() + 1)
                        .codigo("cod-"+nombreDiagnostico)
                        .nombre(nombreDiagnostico)
                        .evoluciones(new ArrayList<>())
                        .build())
                .toList());

        diagnosticos.forEach(diagnostico -> historiaClinica.agregarDiagnostico(diagnostico));

        when(pacienteRepository.findByDni(dniPaciente)).thenReturn(Optional.of(paciente));
        when(historiaClinicaRepository.findById(123456)).thenReturn(Optional.of(historiaClinica));

         */
    }

    @When("el medico redacta para el paciente un informe en la evolucion para el diagnostico {string} eh indica en el mismo {string}")
    public void elMedicoRedactaParaElPacienteUnInformeEnLaEvolucionParaElDiagnosticoEhIndicaEnElMismo(String nombreDiagnostico, String informe) {

        /*

        diagnosticoElegido = paciente.getHistoriaClinica().getDiagnosticos().stream()
                .filter(diagnostico -> diagnostico.getDescripcion().equals(nombreDiagnostico))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontro el diagnostico"));
        this.informe = informe;
        when(diagnosticoRespository.findById(diagnosticoElegido.getId())).thenReturn(Optional.of(diagnosticoElegido));

         */
    }

    @And("el medico guarda la evolucion")
    public void elMedicoGuardaLaEvolucion() {

        /*

        nroHistoriaClinica = paciente.getHistoriaClinica().getNroHistoriaClinica();
        evolucionReqDTO = new EvolucionReqDTO(informe, diagnosticoElegido.getId(), medico.getDni(), pedidoLaboratorioReqDTO, null);

        when(evolucionRepository.save(any(Evolucion.class))).thenAnswer(invocation -> {
            evolucion = invocation.getArgument(0);
            if (evolucion.getPedidoLaboratorio() != null) {
                evolucion.getPedidoLaboratorio().setCodigo(1);
            }
            evolucion.setId(1);
            return evolucion;
        });

        evolucionResDTO = evolucionService.crearEvolucion(nroHistoriaClinica, evolucionReqDTO);

         */
    }

    @Then("se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe y el medico.")
    public void seRegistraLaEvolucionEnLaHistoriaClinicaDelPacienteConElDiagnosticoElInformeYElMedico() {

        /*

        assertThat(evolucionResDTO.getDiagnostico().getCodigo()).isEqualTo(diagnosticoElegido.getCodigo());
        assertThat(evolucionResDTO.getTexto()).isEqualTo(informe);
        assertThat(evolucionResDTO.getMedico().getDni()).isEqualTo(medico.getDni());
        verify(evolucionRepository, times(1)).save(any(Evolucion.class));


         */
    }

    @And("agrega un pedido de laboratorio solicitando un {string} con fecha {string} para el paciente")
    public void agregaUnPedidoDeLaboratorioSolicitandoUnParaElPaciente(String textoPedidoLaboratorio, String fechaPedidoLaboratorio) throws ParseException {

        /*

        this.textoPedidoLaboratorio = textoPedidoLaboratorio;
        this.fechaPedidoLaboratorio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaPedidoLaboratorio);
        pedidoLaboratorioReqDTO = new PedidoLaboratorioReqDTO(textoPedidoLaboratorio, this.fechaPedidoLaboratorio);

         */
    }

    @Then("se registra la evolucion en la historia clinica del paciente con el diagnostico, el informe, el pedido de laboratorio y el medico.")
    public void seRegistraLaEvolucionEnLaHistoriaClinicaDelPacienteConElDiagnosticoElInformeElPedidoDeLaboratorioYElMedico() {

        /*

        assertThat(evolucionResDTO.getDiagnostico().getCodigo()).isEqualTo(diagnosticoElegido.getCodigo());
        assertThat(evolucionResDTO.getTexto()).isEqualTo(informe);
        assertThat(evolucionResDTO.getMedico().getDni()).isEqualTo(medico.getDni());
        assertThat(evolucionResDTO.getPedidoLaboratorio().getDescripcion()).isEqualTo(textoPedidoLaboratorio);
        assertThat(evolucionResDTO.getPedidoLaboratorio().getFecha()).isEqualTo(fechaPedidoLaboratorio);
        verify(evolucionRepository, times(1)).save(any(Evolucion.class));

         */
    }
}
