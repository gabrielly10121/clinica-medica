package br.edu.imepac.controllers;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioCreateRequest request) {
        UsuarioDto usuarioDto = usuarioService.createUsuario(request);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id) {
        UsuarioDto usuarioDto = usuarioService.findById(id);
        if (usuarioDto != null) {
            return ResponseEntity.ok(usuarioDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDetails) {
        UsuarioDto updateUsuario = usuarioService.update(id, usuarioDetails);
        if (updateUsuario != null) {
            return ResponseEntity.ok(updateUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}