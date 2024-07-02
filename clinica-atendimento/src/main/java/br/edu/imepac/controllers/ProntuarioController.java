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
//@Api(value = "Prontuarios", tags = "Prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    ////@ApiOperation(value = "Cria um novo prontuário")
    public ResponseEntity<ProntuarioDto> createProntuario(@RequestBody ProntuarioCreateRequest request) {
        ProntuarioDto prontuario = prontuarioService.createProntuario(request);
        return ResponseEntity.ok(prontuario);
    }

    @GetMapping
    ////@ApiOperation(value = "Lista todos os prontuários")
    public ResponseEntity<List<ProntuarioDto>> getAllProntuarios() {
        List<ProntuarioDto> prontuarios = prontuarioService.getAllProntuarios();
        return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    ////@ApiOperation(value = "Busca um prontuário pelo ID")
    public ResponseEntity<ProntuarioDto> getProntuarioById(@PathVariable Long id) {
        ProntuarioDto prontuario = prontuarioService.getProntuarioById(id);
        if (prontuario != null) {
            return ResponseEntity.ok(prontuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ////@ApiOperation(value = "Atualiza um prontuário pelo ID")
    public ResponseEntity<ProntuarioDto> updateProntuario(@PathVariable Long id, @RequestBody ProntuarioCreateRequest request) {
        ProntuarioDto prontuario = prontuarioService.updateProntuario(id, request);
        return ResponseEntity.ok(prontuario);
    }

    @DeleteMapping("/{id}")
    ////@ApiOperation(value = "Deleta um prontuário pelo ID")
    public ResponseEntity<Void> deleteProntuario(@PathVariable Long id) {
        prontuarioService.deleteProntuario(id);
        return ResponseEntity.noContent().build();
    }
}