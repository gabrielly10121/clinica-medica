package br.edu.imepac.controllers;

import br.edu.imepac.dtos.FuncionarioCreateRequest;
import br.edu.imepac.dtos.FuncionarioDto;
import br.edu.imepac.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
//@Api(value = "Funcionarios", tags = "Funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    ////@ApiOperation(value = "Cria um novo funcionário")
    public ResponseEntity<FuncionarioDto> createFuncionario(@RequestBody FuncionarioCreateRequest request) {
        FuncionarioDto funcionarioDto = funcionarioService.createFuncionario(request);
        return ResponseEntity.ok(funcionarioDto);
    }

    @GetMapping
    ////@ApiOperation(value = "Lista todos os funcionários")
    public ResponseEntity<List<FuncionarioDto>> getAllFuncionarios() {
        List<FuncionarioDto> funcionarios = funcionarioService.getAllFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    ////@ApiOperation(value = "Busca um funcionário pelo ID")
    public ResponseEntity<FuncionarioDto> getFuncionarioById(@PathVariable Long id) {
        FuncionarioDto funcionarioDto = funcionarioService.findById(id);
        if (funcionarioDto != null) {
            return ResponseEntity.ok(funcionarioDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    ////@ApiOperation(value = "Atualiza um funcionário pelo ID")
    public ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDetails) {
        FuncionarioDto updateFuncionario = funcionarioService.update(id, funcionarioDetails);
        if (updateFuncionario != null) {
            return ResponseEntity.ok(updateFuncionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    ////@ApiOperation(value = "Deleta um funcionário pelo ID")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    ////@ApiOperation(value = "Conta o número de funcionários")
    public ResponseEntity<Long> countFuncionarios() {
        long count = funcionarioService.countFuncionarios();
        return ResponseEntity.ok(count);
    }
}