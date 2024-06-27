package br.edu.imepac.services;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.models.EspecialidadeModel;
import br.edu.imepac.repositories.EspecialidadeRepository;
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
public class EspecialidadeServiceTest {

    @Mock
    private EspecialidadeRepository especialidadeRepository;

    @InjectMocks
    private EspecialidadeService especialidadeService;

    private EspecialidadeModel especialidadeModel;
    private EspecialidadeCreateRequest especialidadeCreateRequest;
    private EspecialidadeDto especialidadeDto;

    @BeforeEach
    void setUp() {
        especialidadeModel = new EspecialidadeModel();
        especialidadeModel.setId(1L);
        especialidadeModel.setNome("Cardiologia");
        especialidadeModel.setDescricao("Especialidade médica que se ocupa do diagnóstico e tratamento das doenças do coração.");

        especialidadeCreateRequest = new EspecialidadeCreateRequest();
        especialidadeCreateRequest.setNome("Cardiologia");
        especialidadeCreateRequest.setDescricao("Especialidade médica que se ocupa do diagnóstico e tratamento das doenças do coração.");

        especialidadeDto = new EspecialidadeDto();
        especialidadeDto.setId(1L);
        especialidadeDto.setNome("Cardiologia");
        especialidadeDto.setDescricao("Especialidade médica que se ocupa do diagnóstico e tratamento das doenças do coração.");
    }

    @Test
    void testCreateEspecialidade() {
        when(especialidadeRepository.save(any(EspecialidadeModel.class))).thenReturn(especialidadeModel);

        EspecialidadeDto createdEspecialidade = especialidadeService.createEspecialidade(especialidadeCreateRequest);

        assertNotNull(createdEspecialidade);
        assertEquals(especialidadeDto.getId(), createdEspecialidade.getId());
        assertEquals(especialidadeDto.getNome(), createdEspecialidade.getNome());
        assertEquals(especialidadeDto.getDescricao(), createdEspecialidade.getDescricao());

        verify(especialidadeRepository, times(1)).save(any(EspecialidadeModel.class));
    }

    @Test
    void testGetAllEspecialidades() {
        when(especialidadeRepository.findAll()).thenReturn(Arrays.asList(especialidadeModel));

        List<EspecialidadeDto> especialidades = especialidadeService.getAllEspecialidades();

        assertNotNull(especialidades);
        assertEquals(1, especialidades.size());
        assertEquals(especialidadeDto.getId(), especialidades.get(0).getId());
        assertEquals(especialidadeDto.getNome(), especialidades.get(0).getNome());
        assertEquals(especialidadeDto.getDescricao(), especialidades.get(0).getDescricao());

        verify(especialidadeRepository, times(1)).findAll();
    }

    @Test
    void testDeleteEspecialidade() {
        doNothing().when(especialidadeRepository).deleteById(1L);

        especialidadeService.delete(1L);

        verify(especialidadeRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateEspecialidade() {
        when(especialidadeRepository.findById(1L)).thenReturn(Optional.of(especialidadeModel));
        when(especialidadeRepository.save(any(EspecialidadeModel.class))).thenReturn(especialidadeModel);

        EspecialidadeDto updatedEspecialidade = especialidadeService.update(1L, especialidadeDto);

        assertNotNull(updatedEspecialidade);
        assertEquals(especialidadeDto.getId(), updatedEspecialidade.getId());
        assertEquals(especialidadeDto.getNome(), updatedEspecialidade.getNome());
        assertEquals(especialidadeDto.getDescricao(), updatedEspecialidade.getDescricao());

        verify(especialidadeRepository, times(1)).findById(1L);
        verify(especialidadeRepository, times(1)).save(any(EspecialidadeModel.class));
    }

    @Test
    void testFindById() {
        when(especialidadeRepository.findById(1L)).thenReturn(Optional.of(especialidadeModel));

        EspecialidadeDto foundEspecialidade = especialidadeService.findById(1L);

        assertNotNull(foundEspecialidade);
        assertEquals(especialidadeDto.getId(), foundEspecialidade.getId());
        assertEquals(especialidadeDto.getNome(), foundEspecialidade.getNome());
        assertEquals(especialidadeDto.getDescricao(), foundEspecialidade.getDescricao());

        verify(especialidadeRepository, times(1)).findById(1L);
    }
}