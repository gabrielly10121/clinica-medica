package br.edu.imepac.controllers;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<EspecialidadeDto> createEspecialidade(@RequestBody EspecialidadeCreateRequest request){
        EspecialidadeDto especialidadeDto = especialidadeService.createEspecialidade(request);
        return ResponseEntity.ok(especialidadeDto);
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeDto>> getAllEspecialidades(){
        List<EspecialidadeDto> especialidades = especialidadeService.getAllEspecialidades();
        return ResponseEntity.ok(especialidades);
    }
}
