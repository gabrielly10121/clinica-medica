package br.edu.imepac.controllers;

import br.edu.imepac.dtos.MedicoCreateRequest;
import br.edu.imepac.dtos.MedicoDto;
import br.edu.imepac.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
//@Api(value = "Medico", tags = "Medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    ////@ApiOperation(value = "Cria um novo médico")
    public ResponseEntity<MedicoDto> saveDoctor(@RequestBody MedicoCreateRequest medicoCreateRequest) {
        MedicoDto savedMedico = medicoService.save(medicoCreateRequest);
        return new ResponseEntity<>(savedMedico, HttpStatus.CREATED);
    }

    @GetMapping
    ////@ApiOperation(value = "Lista todos os médicos")
    public ResponseEntity<List<MedicoDto>> listAllDoctors() {
        List<MedicoDto> medicos = medicoService.findAll();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ////@ApiOperation(value = "Busca um médico pelo ID")
    public ResponseEntity<MedicoDto> getDoctorById(@PathVariable Long id) {
        MedicoDto medicoDto = medicoService.findById(id);
        if (medicoDto != null) {
            return new ResponseEntity<>(medicoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    ////@ApiOperation(value = "Atualiza um médico pelo ID")
    public ResponseEntity<MedicoDto> updateDoctor(@PathVariable Long id, @RequestBody MedicoDto medicoDetails) {
        MedicoDto updatedMedico = medicoService.update(id, medicoDetails);
        if (updatedMedico != null) {
            return new ResponseEntity<>(updatedMedico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    ////@ApiOperation(value = "Deleta um médico pelo ID")
    public void deleteDoctor(@PathVariable Long id) {
        medicoService.delete(id);
    }
}