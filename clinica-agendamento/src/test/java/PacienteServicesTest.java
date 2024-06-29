import br.edu.imepac.Model.PacienteModel;
import br.edu.imepac.Repositories.PacienteRepositories;
import br.edu.imepac.Services.PacienteServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PacienteServicesTest {

    @Mock
    private PacienteRepositories pacienteRepository;

    @InjectMocks
    private PacienteServices pacienteService;

    private PacienteModel pacienteModel;

    @BeforeEach
    void setUp() {
        pacienteModel = new PacienteModel();
        pacienteModel.setId(1L);
        pacienteModel.setNome("Paciente Teste");
        pacienteModel.setSobrenome("Sobrenome Teste");
        pacienteModel.setDataNascimento("01/01/2000");
        pacienteModel.setEmail("paciente@teste.com");
        pacienteModel.setTelefone("123456789");
    }

    @Test
    void testSavePaciente() {
        when(pacienteRepository.save(any(PacienteModel.class))).thenReturn(pacienteModel);
        PacienteModel createdPaciente = pacienteService.savePaciente(pacienteModel);
        assertNotNull(createdPaciente);
        assertEquals(pacienteModel.getId(), createdPaciente.getId());
        assertEquals(pacienteModel.getNome(), createdPaciente.getNome());
        verify(pacienteRepository, times(1)).save(any(PacienteModel.class));
    }

    @Test
    void testGetAllPacientes() {
        when(pacienteRepository.findAll()).thenReturn(Arrays.asList(pacienteModel));
        List<PacienteModel> pacientes = pacienteService.getAllPacientes();
        assertNotNull(pacientes);
        assertEquals(1, pacientes.size());
        assertEquals(pacienteModel.getId(), pacientes.get(0).getId());
        verify(pacienteRepository, times(1)).findAll();
    }

    @Test
    void testGetPacienteById() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(pacienteModel));
        PacienteModel foundPaciente = pacienteService.getPacienteById(1L);
        assertNotNull(foundPaciente);
        assertEquals(pacienteModel.getId(), foundPaciente.getId());
        verify(pacienteRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdatePaciente() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(pacienteModel));
        when(pacienteRepository.save(any(PacienteModel.class))).thenReturn(pacienteModel);
        PacienteModel updatedPaciente = pacienteService.updatePaciente(1L, pacienteModel);
        assertNotNull(updatedPaciente);
        assertEquals(pacienteModel.getId(), updatedPaciente.getId());
        assertEquals(pacienteModel.getNome(), updatedPaciente.getNome());
        verify(pacienteRepository, times(1)).findById(1L);
        verify(pacienteRepository, times(1)).save(any(PacienteModel.class));
    }

    @Test
    void testDeletePaciente() {
        doNothing().when(pacienteRepository).deleteById(1L);
        pacienteService.deletePaciente(1L);
        verify(pacienteRepository, times(1)).deleteById(1L);
    }
}