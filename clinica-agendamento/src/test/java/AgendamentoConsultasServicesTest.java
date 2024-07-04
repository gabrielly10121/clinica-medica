
import br.edu.imepac.Dtos.AgendamentoConsultasCreateRequest;
import br.edu.imepac.Dtos.AgendamentoConsultasDto;
import br.edu.imepac.Model.AgendamentoConsultasModel;
import br.edu.imepac.Repositories.AgendamentoConsultasRepositories;
import br.edu.imepac.Services.AgendamentoConsultasServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AgendamentoConsultasServicesTest {

    @InjectMocks
    private AgendamentoConsultasServices service;

    @Mock
    private AgendamentoConsultasRepositories repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        AgendamentoConsultasModel consulta = new AgendamentoConsultasModel();
        consulta.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(consulta));

        AgendamentoConsultasDto result = service.findById(1L);

        assertNotNull(result);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testAgendarConsulta() {
        AgendamentoConsultasCreateRequest request = new AgendamentoConsultasCreateRequest();
        AgendamentoConsultasModel consulta = new AgendamentoConsultasModel();
        when(repository.save(any(AgendamentoConsultasModel.class))).thenReturn(consulta);

        AgendamentoConsultasDto result = service.agendarConsulta(request);

        assertNotNull(result);
        verify(repository, times(1)).save(any(AgendamentoConsultasModel.class));
    }

    @Test
    public void testCancelarConsulta() {
        AgendamentoConsultasModel consulta = new AgendamentoConsultasModel();
        consulta.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(consulta));
        when(repository.save(any(AgendamentoConsultasModel.class))).thenReturn(consulta);

        AgendamentoConsultasDto result = service.cancelarConsulta(1L, "Motivo");

        assertNotNull(result);
        assertEquals("Sim", consulta.getConsultaCancelada());
        assertEquals("Motivo", consulta.getMotivoCancelamento());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(consulta);
    }

    @Test
    public void testRegistrarRetorno() {
        AgendamentoConsultasModel consulta = new AgendamentoConsultasModel();
        consulta.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(consulta));
        when(repository.save(any(AgendamentoConsultasModel.class))).thenReturn(consulta);

        AgendamentoConsultasDto result = service.registrarRetorno(1L, "2023-10-10", "10:00");

        assertNotNull(result);
        assertEquals("Sim", consulta.getRetornoConsulta());
        assertEquals("2023-10-10", consulta.getDataConsulta());
        assertEquals("10:00", consulta.getHoraConsulta());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(consulta);
    }
}