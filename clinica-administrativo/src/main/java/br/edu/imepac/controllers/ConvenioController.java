package br.edu.imepac.controllers;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.services.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {
    @Autowired
    private ConvenioService convenioService;

    @PostMapping
    public ResponseEntity<ConvenioDto> createConvenio(@RequestBody ConvenioCreateRequest request) {
        ConvenioDto convenioDto = convenioService.createConvenio(request);
        return ResponseEntity.ok(convenioDto);
    }

    @GetMapping
    public ResponseEntity<List<ConvenioDto>> getAllConvenios() {
        List<ConvenioDto> convenios = convenioService.getAllConvenios();
        return ResponseEntity.ok(convenios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioDto> getConvenioById(@PathVariable Long id) {
        ConvenioDto convenioDto = convenioService.findById(id);
        if (convenioDto != null) {
            return ResponseEntity.ok(convenioDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvenioDto> updateConvenio(@PathVariable Long id, @RequestBody ConvenioDto convenioDetails) {
        ConvenioDto updatedConvenio = convenioService.update(id, convenioDetails);
        if (updatedConvenio != null) {
            return ResponseEntity.ok(updatedConvenio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConvenio(@PathVariable Long id) {
        convenioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}