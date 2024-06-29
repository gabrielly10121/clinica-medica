import br.edu.imepac.dtos.MedicoCreateRequest;
import br.edu.imepac.dtos.MedicoDto;
import br.edu.imepac.models.MedicoModel;
import br.edu.imepac.repositories.MedicoRepository;
import br.edu.imepac.services.MedicoService;
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
public class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    private MedicoModel medicoModel;
    private MedicoCreateRequest medicoCreateRequest;
    private MedicoDto medicoDto;

    @BeforeEach
    void setUp() {
        medicoModel = new MedicoModel();
        medicoModel.setId(1L);
        medicoModel.setNome("Medico Teste");
        medicoModel.setCrm("123456");
        medicoModel.setSenha("senha123");

        medicoCreateRequest = new MedicoCreateRequest();
        medicoCreateRequest.setNome("Medico Teste");
        medicoCreateRequest.setCrm("123456");
        medicoCreateRequest.setSenha("senha123");

        medicoDto = new MedicoDto();
        medicoDto.setId(1L);
        medicoDto.setNome("Medico Teste");
        medicoDto.setCrm("123456");
    }

    @Test
    void testSaveMedico() {
        when(medicoRepository.save(any(MedicoModel.class))).thenReturn(medicoModel);

        MedicoDto createdMedico = medicoService.save(medicoCreateRequest);

        assertNotNull(createdMedico);
        assertEquals(medicoDto.getId(), createdMedico.getId());
        assertEquals(medicoDto.getNome(), createdMedico.getNome());
        assertEquals(medicoDto.getCrm(), createdMedico.getCrm());

        verify(medicoRepository, times(1)).save(any(MedicoModel.class));
    }

    @Test
    void testFindAllMedicos() {
        when(medicoRepository.findAll()).thenReturn(Arrays.asList(medicoModel));

        List<MedicoDto> medicos = medicoService.findAll();

        assertNotNull(medicos);
        assertEquals(1, medicos.size());
        assertEquals(medicoDto.getId(), medicos.get(0).getId());
        assertEquals(medicoDto.getNome(), medicos.get(0).getNome());
        assertEquals(medicoDto.getCrm(), medicos.get(0).getCrm());

        verify(medicoRepository, times(1)).findAll();
    }

    @Test
    void testDeleteMedico() {
        doNothing().when(medicoRepository).deleteById(1L);

        medicoService.delete(1L);

        verify(medicoRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateMedico() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medicoModel));
        when(medicoRepository.save(any(MedicoModel.class))).thenReturn(medicoModel);

        MedicoDto updatedMedico = medicoService.update(1L, medicoDto);

        assertNotNull(updatedMedico);
        assertEquals(medicoDto.getId(), updatedMedico.getId());
        assertEquals(medicoDto.getNome(), updatedMedico.getNome());
        assertEquals(medicoDto.getCrm(), updatedMedico.getCrm());

        verify(medicoRepository, times(1)).findById(1L);
        verify(medicoRepository, times(1)).save(any(MedicoModel.class));
    }

    @Test
    void testFindById() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medicoModel));

        MedicoDto foundMedico = medicoService.findById(1L);

        assertNotNull(foundMedico);
        assertEquals(medicoDto.getId(), foundMedico.getId());
        assertEquals(medicoDto.getNome(), foundMedico.getNome());
        assertEquals(medicoDto.getCrm(), foundMedico.getCrm());

        verify(medicoRepository, times(1)).findById(1L);
    }
}