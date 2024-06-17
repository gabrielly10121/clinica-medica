package br.edu.imepac.services;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.dtos.repositories.ConvenioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConvenioServiceTest {

    @InjectMocks
    private ConvenioService convenioService;

    @Mock
    private ConvenioRepository convenioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateConvenio() {
        ConvenioCreateRequest request = new ConvenioCreateRequest();
        request.setNome("Convenio Teste");
        request.setCodigo("123");
        request.setTipo("Tipo Teste");
        request.setDescricao("Descricao Teste");
        request.setTelefone("123456789");
        request.setEmail("teste@teste.com");
        request.setEndereco("Endereco Teste");

        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setId(1L);
        convenioModel.setNome(request.getNome());
        convenioModel.setCodigo(request.getCodigo());
        convenioModel.setTipo(request.getTipo());
        convenioModel.setDescricao(request.getDescricao());
        convenioModel.setTelefone(request.getTelefone());
        convenioModel.setEmail(request.getEmail());
        convenioModel.setEndereco(request.getEndereco());

        when(convenioRepository.save(any(ConvenioModel.class))).thenReturn(convenioModel);

        ConvenioDto result = convenioService.createConvenio(request);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Convenio Teste", result.getNome());
    }

    @Test
    void testGetAllConvenios() {
        ConvenioModel convenioModel1 = new ConvenioModel();
        convenioModel1.setId(1L);
        convenioModel1.setNome("Convenio 1");

        ConvenioModel convenioModel2 = new ConvenioModel();
        convenioModel2.setId(2L);
        convenioModel2.setNome("Convenio 2");

        when(convenioRepository.findAll()).thenReturn(Arrays.asList(convenioModel1, convenioModel2));

        List<ConvenioDto> result = convenioService.getAllConvenios();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteConvenio() {
        doNothing().when(convenioRepository).deleteById(1L);

        convenioService.delete(1L);

        verify(convenioRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateConvenio() {
        ConvenioDto convenioDto = new ConvenioDto();
        convenioDto.setNome("Convenio Atualizado");

        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setId(1L);
        convenioModel.setNome("Convenio Original");

        when(convenioRepository.findById(1L)).thenReturn(Optional.of(convenioModel));
        when(convenioRepository.save(any(ConvenioModel.class))).thenReturn(convenioModel);

        ConvenioDto result = convenioService.update(1L, convenioDto);

        assertNotNull(result);
        assertEquals("Convenio Atualizado", result.getNome());
    }

    @Test
    void testFindById() {
        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setId(1L);
        convenioModel.setNome("Convenio Teste");

        when(convenioRepository.findById(1L)).thenReturn(Optional.of(convenioModel));

        ConvenioDto result = convenioService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Convenio Teste", result.getNome());
    }
}