import br.edu.imepac.dtos.FuncionarioCreateRequest;
import br.edu.imepac.dtos.FuncionarioDto;
import br.edu.imepac.models.FuncionarioModel;
import br.edu.imepac.repositories.FuncionarioRepository;
import br.edu.imepac.services.FuncionarioService;
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
public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private FuncionarioModel funcionarioModel;
    private FuncionarioCreateRequest funcionarioCreateRequest;
    private FuncionarioDto funcionarioDto;

    @BeforeEach
    void setUp() {
        funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(1L);
        funcionarioModel.setNomeCompleto("Funcionario Teste");
        funcionarioModel.setRg("123456789");
        funcionarioModel.setOrgaoEmissor("SSP");
        funcionarioModel.setCpf("123.456.789-00");
        funcionarioModel.setEndereco("Endereco Teste");
        funcionarioModel.setNumero("123");
        funcionarioModel.setBairro("Bairro Teste");
        funcionarioModel.setCidade("Cidade Teste");
        funcionarioModel.setEstado("Estado Teste");
        funcionarioModel.setTelefone("123456789");
        funcionarioModel.setSexo("M");
        funcionarioModel.setDataNascimento("01/01/2000");

        funcionarioCreateRequest = new FuncionarioCreateRequest();
        funcionarioCreateRequest.setNomeCompleto("Funcionario Teste");
        funcionarioCreateRequest.setRg("123456789");
        funcionarioCreateRequest.setOrgaoEmissor("SSP");
        funcionarioCreateRequest.setCpf("123.456.789-00");
        funcionarioCreateRequest.setEndereco("Endereco Teste");
        funcionarioCreateRequest.setNumero("123");
        funcionarioCreateRequest.setBairro("Bairro Teste");
        funcionarioCreateRequest.setCidade("Cidade Teste");
        funcionarioCreateRequest.setEstado("Estado Teste");
        funcionarioCreateRequest.setTelefone("123456789");
        funcionarioCreateRequest.setSexo("M");
        funcionarioCreateRequest.setDataNascimento("01/01/2000");

        funcionarioDto = new FuncionarioDto();
        funcionarioDto.setId(1L);
        funcionarioDto.setNomeCompleto("Funcionario Teste");
        funcionarioDto.setRg("123456789");
        funcionarioDto.setOrgaoEmissor("SSP");
        funcionarioDto.setCpf("123.456.789-00");
        funcionarioDto.setEndereco("Endereco Teste");
        funcionarioDto.setNumero("123");
        funcionarioDto.setBairro("Bairro Teste");
        funcionarioDto.setCidade("Cidade Teste");
        funcionarioDto.setEstado("Estado Teste");
        funcionarioDto.setTelefone("123456789");
        funcionarioDto.setSexo("M");
        funcionarioDto.setDataNascimento("01/01/2000");
    }

    @Test
    void testCreateFuncionario() {
        when(funcionarioRepository.save(any(FuncionarioModel.class))).thenReturn(funcionarioModel);
        FuncionarioDto createdFuncionario = funcionarioService.createFuncionario(funcionarioCreateRequest);
        assertNotNull(createdFuncionario);
        assertEquals(funcionarioDto.getId(), createdFuncionario.getId());
        assertEquals(funcionarioDto.getNomeCompleto(), createdFuncionario.getNomeCompleto());
        assertEquals(funcionarioDto.getRg(), createdFuncionario.getRg());
        assertEquals(funcionarioDto.getOrgaoEmissor(), createdFuncionario.getOrgaoEmissor());
        assertEquals(funcionarioDto.getCpf(), createdFuncionario.getCpf());
        assertEquals(funcionarioDto.getEndereco(), createdFuncionario.getEndereco());
        assertEquals(funcionarioDto.getNumero(), createdFuncionario.getNumero());
        assertEquals(funcionarioDto.getBairro(), createdFuncionario.getBairro());
        assertEquals(funcionarioDto.getCidade(), createdFuncionario.getCidade());
        assertEquals(funcionarioDto.getEstado(), createdFuncionario.getEstado());
        assertEquals(funcionarioDto.getTelefone(), createdFuncionario.getTelefone());
        assertEquals(funcionarioDto.getSexo(), createdFuncionario.getSexo());
        assertEquals(funcionarioDto.getDataNascimento(), createdFuncionario.getDataNascimento());
        verify(funcionarioRepository, times(1)).save(any(FuncionarioModel.class));
    }

    @Test
    void testGetAllFuncionarios() {
        when(funcionarioRepository.findAll()).thenReturn(Arrays.asList(funcionarioModel));
        List<FuncionarioDto> funcionarios = funcionarioService.getAllFuncionarios();
        assertNotNull(funcionarios);
        assertEquals(1, funcionarios.size());
        assertEquals(funcionarioDto.getId(), funcionarios.get(0).getId());
        assertEquals(funcionarioDto.getNomeCompleto(), funcionarios.get(0).getNomeCompleto());
        assertEquals(funcionarioDto.getRg(), funcionarios.get(0).getRg());
        assertEquals(funcionarioDto.getOrgaoEmissor(), funcionarios.get(0).getOrgaoEmissor());
        assertEquals(funcionarioDto.getCpf(), funcionarios.get(0).getCpf());
        assertEquals(funcionarioDto.getEndereco(), funcionarios.get(0).getEndereco());
        assertEquals(funcionarioDto.getNumero(), funcionarios.get(0).getNumero());
        assertEquals(funcionarioDto.getBairro(), funcionarios.get(0).getBairro());
        assertEquals(funcionarioDto.getCidade(), funcionarios.get(0).getCidade());
        assertEquals(funcionarioDto.getEstado(), funcionarios.get(0).getEstado());
        assertEquals(funcionarioDto.getTelefone(), funcionarios.get(0).getTelefone());
        assertEquals(funcionarioDto.getSexo(), funcionarios.get(0).getSexo());
        assertEquals(funcionarioDto.getDataNascimento(), funcionarios.get(0).getDataNascimento());
        verify(funcionarioRepository, times(1)).findAll();
    }

    @Test
    void testDeleteFuncionario() {
        doNothing().when(funcionarioRepository).deleteById(1L);
        funcionarioService.delete(1L);
        verify(funcionarioRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateFuncionario() {
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionarioModel));
        when(funcionarioRepository.save(any(FuncionarioModel.class))).thenReturn(funcionarioModel);
        FuncionarioDto updatedFuncionario = funcionarioService.update(1L, funcionarioDto);
        assertNotNull(updatedFuncionario);
        assertEquals(funcionarioDto.getId(), updatedFuncionario.getId());
        assertEquals(funcionarioDto.getNomeCompleto(), updatedFuncionario.getNomeCompleto());
        assertEquals(funcionarioDto.getRg(), updatedFuncionario.getRg());
        assertEquals(funcionarioDto.getOrgaoEmissor(), updatedFuncionario.getOrgaoEmissor());
        assertEquals(funcionarioDto.getCpf(), updatedFuncionario.getCpf());
        assertEquals(funcionarioDto.getEndereco(), updatedFuncionario.getEndereco());
        assertEquals(funcionarioDto.getNumero(), updatedFuncionario.getNumero());
        assertEquals(funcionarioDto.getBairro(), updatedFuncionario.getBairro());
        assertEquals(funcionarioDto.getCidade(), updatedFuncionario.getCidade());
        assertEquals(funcionarioDto.getEstado(), updatedFuncionario.getEstado());
        assertEquals(funcionarioDto.getTelefone(), updatedFuncionario.getTelefone());
        assertEquals(funcionarioDto.getSexo(), updatedFuncionario.getSexo());
        assertEquals(funcionarioDto.getDataNascimento(), updatedFuncionario.getDataNascimento());
        verify(funcionarioRepository, times(1)).findById(1L);
        verify(funcionarioRepository, times(1)).save(any(FuncionarioModel.class));
    }

    @Test
    void testFindById() {
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionarioModel));
        FuncionarioDto foundFuncionario = funcionarioService.findById(1L);
        assertNotNull(foundFuncionario);
        assertEquals(funcionarioDto.getId(), foundFuncionario.getId());
        assertEquals(funcionarioDto.getNomeCompleto(), foundFuncionario.getNomeCompleto());
        assertEquals(funcionarioDto.getRg(), foundFuncionario.getRg());
        assertEquals(funcionarioDto.getOrgaoEmissor(), foundFuncionario.getOrgaoEmissor());
        assertEquals(funcionarioDto.getCpf(), foundFuncionario.getCpf());
        assertEquals(funcionarioDto.getEndereco(), foundFuncionario.getEndereco());
        assertEquals(funcionarioDto.getNumero(), foundFuncionario.getNumero());
        assertEquals(funcionarioDto.getBairro(), foundFuncionario.getBairro());
        assertEquals(funcionarioDto.getCidade(), foundFuncionario.getCidade());
        assertEquals(funcionarioDto.getEstado(), foundFuncionario.getEstado());
        assertEquals(funcionarioDto.getTelefone(), foundFuncionario.getTelefone());
        assertEquals(funcionarioDto.getSexo(), foundFuncionario.getSexo());
        assertEquals(funcionarioDto.getDataNascimento(), foundFuncionario.getDataNascimento());
        verify(funcionarioRepository, times(1)).findById(1L);
    }
}