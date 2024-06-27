package br.edu.imepac.services;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.models.UsuarioModel;
import br.edu.imepac.repositories.UsuarioRepository;
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

class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioModel usuario;
    private UsuarioCreateRequest usuarioCreateRequest;
    private UsuarioDto usuarioDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new UsuarioModel();
        usuario.setId(1L);
        usuario.setNome("Usuario Teste");
        usuario.setEmail("teste@teste.com");
        usuario.setSenha("senha123");
        usuario.setTelefone("123456789");
        usuario.setEndereco("Endereco Teste");

        usuarioCreateRequest = new UsuarioCreateRequest();
        usuarioCreateRequest.setNome("Usuario Teste");
        usuarioCreateRequest.setEmail("teste@teste.com");
        usuarioCreateRequest.setSenha("senha123");
        usuarioCreateRequest.setTelefone("123456789");
        usuarioCreateRequest.setEndereco("Endereco Teste");

        usuarioDto = new UsuarioDto();
        usuarioDto.setId(1L);
        usuarioDto.setNome("Usuario Teste");
        usuarioDto.setEmail("teste@teste.com");
        usuarioDto.setTelefone("123456789");
        usuarioDto.setEndereco("Endereco Teste");
    }

    @Test
    void testCreateUsuario() {
        when(usuarioRepository.save(any(UsuarioModel.class))).thenReturn(usuario);
        UsuarioDto createdUsuario = usuarioService.createUsuario(usuarioCreateRequest);
        assertNotNull(createdUsuario);
        assertEquals(usuarioDto.getId(), createdUsuario.getId());
        assertEquals(usuarioDto.getNome(), createdUsuario.getNome());
        assertEquals(usuarioDto.getEmail(), createdUsuario.getEmail());
        assertEquals(usuarioDto.getTelefone(), createdUsuario.getTelefone());
        assertEquals(usuarioDto.getEndereco(), createdUsuario.getEndereco());
        verify(usuarioRepository, times(1)).save(any(UsuarioModel.class));
    }

    @Test
    void testGetAllUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));
        List<UsuarioDto> usuarios = usuarioService.getAllUsuarios();
        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
        assertEquals(usuarioDto.getId(), usuarios.get(0).getId());
        assertEquals(usuarioDto.getNome(), usuarios.get(0).getNome());
        assertEquals(usuarioDto.getEmail(), usuarios.get(0).getEmail());
        assertEquals(usuarioDto.getTelefone(), usuarios.get(0).getTelefone());
        assertEquals(usuarioDto.getEndereco(), usuarios.get(0).getEndereco());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUsuario() {
        doNothing().when(usuarioRepository).deleteById(1L);
        usuarioService.delete(1L);
        verify(usuarioRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateUsuario() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(UsuarioModel.class))).thenReturn(usuario);
        UsuarioDto updatedUsuario = usuarioService.update(1L, usuarioDto);
        assertNotNull(updatedUsuario);
        assertEquals(usuarioDto.getId(), updatedUsuario.getId());
        assertEquals(usuarioDto.getNome(), updatedUsuario.getNome());
        assertEquals(usuarioDto.getEmail(), updatedUsuario.getEmail());
        assertEquals(usuarioDto.getTelefone(), updatedUsuario.getTelefone());
        assertEquals(usuarioDto.getEndereco(), updatedUsuario.getEndereco());
        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(any(UsuarioModel.class));
    }

    @Test
    void testFindById() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        UsuarioDto foundUsuario = usuarioService.findById(1L);
        assertNotNull(foundUsuario);
        assertEquals(usuarioDto.getId(), foundUsuario.getId());
        assertEquals(usuarioDto.getNome(), foundUsuario.getNome());
        assertEquals(usuarioDto.getEmail(), foundUsuario.getEmail());
        assertEquals(usuarioDto.getTelefone(), foundUsuario.getTelefone());
        assertEquals(usuarioDto.getEndereco(), foundUsuario.getEndereco());
        verify(usuarioRepository, times(1)).findById(1L);
    }
}