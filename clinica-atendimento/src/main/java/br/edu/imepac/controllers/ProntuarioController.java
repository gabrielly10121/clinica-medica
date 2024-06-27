package br.edu.imepac.controllers;

import br.edu.imepac.dtos.ProntuarioCreateRequest;
import br.edu.imepac.dtos.ProntuarioDto;
import br.edu.imepac.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<ProntuarioDto> createProntuario(@RequestBody ProntuarioCreateRequest request) {
        ProntuarioDto prontuario = prontuarioService.createProntuario(request);
        return ResponseEntity.ok(prontuario);
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDto>> getAllProntuarios() {
        List<ProntuarioDto> prontuarios = prontuarioService.getAllProntuarios();
        return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDto> getProntuarioById(@PathVariable int id) {
        ProntuarioDto prontuario = prontuarioService.getProntuarioById(id);
        if (prontuario != null) {
            return ResponseEntity.ok(prontuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioDto> updateProntuario(@PathVariable int id, @RequestBody ProntuarioCreateRequest request) {
        ProntuarioDto prontuario = prontuarioService.updateProntuario(id, request);
        return ResponseEntity.ok(prontuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProntuario(@PathVariable int id) {
        prontuarioService.deleteProntuario(id);
        return ResponseEntity.noContent().build();
    }
}