package br.edu.imepac.services;

import br.edu.imepac.dtos.ProntuarioCreateRequest;
import br.edu.imepac.dtos.ProntuarioDto;
import br.edu.imepac.models.ProntuarioModel;
import br.edu.imepac.repositories.ProntuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProntuarioServiceTest {

    @InjectMocks
    private ProntuarioService prontuarioService;

    @Mock
    private ProntuarioRepository prontuarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProntuario() {
        ProntuarioCreateRequest request = new ProntuarioCreateRequest();
        request.setCodigoPaciente(1);
        request.setHistorico("Historico");
        request.setReceituario("Receituario");
        request.setExame("Exame");

        ProntuarioModel prontuario = new ProntuarioModel();
        prontuario.setRegistroAgenda(1);
        prontuario.setCodigoPaciente(1);
        prontuario.setHistorico("Historico");
        prontuario.setReceituario("Receituario");
        prontuario.setExame("Exame");

        when(prontuarioRepository.save(any(ProntuarioModel.class))).thenReturn(prontuario);

        ProntuarioDto result = prontuarioService.createProntuario(request);

        assertNotNull(result);
        assertEquals(1, result.getRegistroAgenda());
        assertEquals(1, result.getCodigoPaciente());
        assertEquals("Historico", result.getHistorico());
        assertEquals("Receituario", result.getReceituario());
        assertEquals("Exame", result.getExame());
    }

    @Test
    void testGetProntuarioById() {
        ProntuarioModel prontuario = new ProntuarioModel();
        prontuario.setRegistroAgenda(1);
        prontuario.setCodigoPaciente(1);
        prontuario.setHistorico("Historico");
        prontuario.setReceituario("Receituario");
        prontuario.setExame("Exame");

        when(prontuarioRepository.findById(1L)).thenReturn(Optional.of(prontuario));

        ProntuarioDto result = prontuarioService.getProntuarioById(1);

        assertNotNull(result);
        assertEquals(1, result.getRegistroAgenda());
        assertEquals(1, result.getCodigoPaciente());
        assertEquals("Historico", result.getHistorico());
        assertEquals("Receituario", result.getReceituario());
        assertEquals("Exame", result.getExame());
    }

    @Test
    void testUpdateProntuario() {
        ProntuarioCreateRequest request = new ProntuarioCreateRequest();
        request.setCodigoPaciente(1);
        request.setHistorico("Updated Historico");
        request.setReceituario("Updated Receituario");
        request.setExame("Updated Exame");

        ProntuarioModel prontuario = new ProntuarioModel();
        prontuario.setRegistroAgenda(1);
        prontuario.setCodigoPaciente(1);
        prontuario.setHistorico("Historico");
        prontuario.setReceituario("Receituario");
        prontuario.setExame("Exame");

        when(prontuarioRepository.findById(1L)).thenReturn(Optional.of(prontuario));
        when(prontuarioRepository.save(any(ProntuarioModel.class))).thenReturn(prontuario);

        ProntuarioDto result = prontuarioService.updateProntuario(1, request);

        assertNotNull(result);
        assertEquals(1, result.getRegistroAgenda());
        assertEquals(1, result.getCodigoPaciente());
        assertEquals("Updated Historico", result.getHistorico());
        assertEquals("Updated Receituario", result.getReceituario());
        assertEquals("Updated Exame", result.getExame());
    }

    @Test
    void testDeleteProntuario() {
        doNothing().when(prontuarioRepository).deleteById(1L);

        prontuarioService.deleteProntuario(1);

        verify(prontuarioRepository, times(1)).deleteById(1L);
    }
}