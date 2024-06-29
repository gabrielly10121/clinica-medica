package br.edu.imepac.services;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.models.UsuarioModel;
import br.edu.imepac.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto createUsuario(UsuarioCreateRequest request) {
        logger.info("Creating new Usuario with nome: {}", request.getNome());
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setTelefone(request.getTelefone());
        usuario.setEndereco(request.getEndereco());

        UsuarioModel savedUsuario = usuarioRepository.save(usuario);

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(savedUsuario.getId());
        usuarioDto.setNome(savedUsuario.getNome());
        usuarioDto.setEmail(savedUsuario.getEmail());
        usuarioDto.setTelefone(savedUsuario.getTelefone());
        usuarioDto.setEndereco(savedUsuario.getEndereco());

        logger.info("Usuario created with id: {}", savedUsuario.getId());
        return usuarioDto;
    }

    public List<UsuarioDto> getAllUsuarios() {
        logger.info("Fetching all Usuarios");
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> {
            UsuarioDto dto = new UsuarioDto();
            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setEmail(usuario.getEmail());
            dto.setTelefone(usuario.getTelefone());
            dto.setEndereco(usuario.getEndereco());
            return dto;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        logger.info("Deleting Usuario with id: {}", id);
        usuarioRepository.deleteById(id);
    }

    public UsuarioDto update(Long id, UsuarioDto usuarioDetails) {
        logger.info("Updating Usuario with id: {}", id);
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuario = optionalUsuario.get();
            usuario.setNome(usuarioDetails.getNome());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setTelefone(usuarioDetails.getTelefone());
            usuario.setEndereco(usuarioDetails.getEndereco());

            UsuarioModel updatedUsuario = usuarioRepository.save(usuario);

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(updatedUsuario.getId());
            usuarioDto.setNome(updatedUsuario.getNome());
            usuarioDto.setEmail(updatedUsuario.getEmail());
            usuarioDto.setTelefone(updatedUsuario.getTelefone());
            usuarioDto.setEndereco(updatedUsuario.getEndereco());

            logger.info("Usuario updated with id: {}", updatedUsuario.getId());
            return usuarioDto;
        } else {
            logger.error("Usuario with id: {} not found", id);
            return null;
        }
    }

    public UsuarioDto findById(Long id) {
        logger.info("Finding Usuario with id: {}", id);
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuario = optionalUsuario.get();
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setTelefone(usuario.getTelefone());
            usuarioDto.setEndereco(usuario.getEndereco());
            return usuarioDto;
        } else {
            logger.error("Usuario with id: {} not found", id);
            return null;
        }
    }
}