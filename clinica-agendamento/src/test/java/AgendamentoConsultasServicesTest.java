import br.edu.imepac.Dtos.AgendamentoConsultasDto;
import br.edu.imepac.Model.AgendamentoConsultasModel;
import br.edu.imepac.Repositories.AgendamentoConsultasRepositories;
import br.edu.imepac.Services.AgendamentoConsultasServices;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@Data
public class AgendamentoConsultasServicesTest {
    @InjectMocks
    private AgendamentoConsultasServices agendamentoConsultasService;

    @Mock
    private AgendamentoConsultasRepositories agendamentoConsultasRepositories;

    public AgendamentoConsultasServicesTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgendarConsulta() {
        AgendamentoConsultasDto agendamentoConsultasDto = new AgendamentoConsultasDto();
        agendamentoConsultasDto.setCodigoPaciente(1);
        agendamentoConsultasDto.setCodigoMedico(1);
        agendamentoConsultasDto.setDataConsulta("2023-10-10");
        agendamentoConsultasDto.setHoraConsulta("10:00");
        agendamentoConsultasDto.setRetornoConsulta("Não");
        agendamentoConsultasDto.setConsultaCancelada("Não");
        agendamentoConsultasDto.setMotivoCancelamento("");

        AgendamentoConsultasModel consulta = new AgendamentoConsultasModel();
        consulta.setRegistro(1);
        consulta.setCodigoPaciente(agendamentoConsultasDto.getCodigoPaciente());
        consulta.setCodigoMedico(agendamentoConsultasDto.getCodigoMedico());
        consulta.setDataConsulta(agendamentoConsultasDto.getDataConsulta());
        consulta.setHoraConsulta(agendamentoConsultasDto.getHoraConsulta());
        consulta.setRetornoConsulta(agendamentoConsultasDto.getRetornoConsulta());
        consulta.setConsultaCancelada(agendamentoConsultasDto.getConsultaCancelada());
        consulta.setMotivoCancelamento(agendamentoConsultasDto.getMotivoCancelamento());

        when(agendamentoConsultasRepositories.save(any(AgendamentoConsultasModel.class))).thenReturn(consulta);

        AgendamentoConsultasModel consultaAgendada = agendamentoConsultasService.save(consulta);

        assertNotNull(consultaAgendada);
        assertNotNull(consultaAgendada.getRegistro());
    }
}
