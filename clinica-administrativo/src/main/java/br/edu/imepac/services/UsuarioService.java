package br.edu.imepac.services;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.models.UsuarioModel;
import br.edu.imepac.dtos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto createUsuario(UsuarioCreateRequest request) {
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

        return usuarioDto;
    }

    public List<UsuarioDto> getAllUsuarios() {
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
        usuarioRepository.deleteById(id);
    }

    public UsuarioDto update(Long id, UsuarioDto usuarioDetails) {
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

            return usuarioDto;
        } else {
            return null;
        }
    }

    public UsuarioDto findById(Long id) {
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
            return null;
        }
    }
}