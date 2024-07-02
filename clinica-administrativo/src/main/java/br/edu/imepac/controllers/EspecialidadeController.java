package br.edu.imepac.controllers;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especialidades")
//@Api(value = "Especialidades", tags = "Especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    ////@ApiOperation(value = "Cria uma nova especialidade")
    public ResponseEntity<EspecialidadeDto> createEspecialidade(@RequestBody EspecialidadeCreateRequest request){
        EspecialidadeDto especialidadeDto = especialidadeService.createEspecialidade(request);
        return ResponseEntity.ok(especialidadeDto);
    }

    @GetMapping
    ////@ApiOperation(value = "Lista todas as especialidades")
    public ResponseEntity<List<EspecialidadeDto>> getAllEspecialidades(){
        List<EspecialidadeDto> especialidades = especialidadeService.getAllEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    ////@ApiOperation(value = "Busca uma especialidade pelo ID")
    public ResponseEntity<EspecialidadeDto> getEspecialidadeById(@PathVariable Long id){
        EspecialidadeDto especialidadeDto = especialidadeService.findById(id);
        if (especialidadeDto != null) {
            return ResponseEntity.ok(especialidadeDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    ////@ApiOperation(value = "Atualiza uma especialidade pelo ID")
    public ResponseEntity<EspecialidadeDto> updateEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeDto especialidadeDetails){
        EspecialidadeDto updateEspecialidade = especialidadeService.update(id, especialidadeDetails);
        if (updateEspecialidade != null) {
            return ResponseEntity.ok(updateEspecialidade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    ////@ApiOperation(value = "Deleta uma especialidade pelo ID")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id){
        especialidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}