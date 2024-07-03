package br.edu.imepac.controllers;

import br.edu.imepac.Dtos.PacienteCreateRequest;
import br.edu.imepac.Model.PacienteModel;
import br.edu.imepac.Services.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
//@Api(value = "Pacientes", tags = "Pacientes")
public class PacienteControllers {

    @Autowired
    private PacienteServices pacienteService;

    @GetMapping
    ////@ApiOperation(value = "Lista todos os pacientes")
    public List<PacienteModel> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping
    ////@ApiOperation(value = "Cria um novo paciente")
    public PacienteModel createPaciente(@RequestBody PacienteCreateRequest pacienteRequest) {
        PacienteModel paciente = new PacienteModel();
        paciente.setNome(pacienteRequest.getNome());
        paciente.setSobrenome(pacienteRequest.getSobrenome());
        paciente.setDataNascimento(pacienteRequest.getDataNascimento());
        paciente.setEmail(pacienteRequest.getEmail());
        paciente.setTelefone(pacienteRequest.getTelefone());
        return pacienteService.savePaciente(paciente);
    }

    @GetMapping("/{id}")
    ////@ApiOperation(value = "Busca um paciente pelo ID")
    public PacienteModel getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @DeleteMapping("/{id}")
    ////@ApiOperation(value = "Deleta um paciente pelo ID")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}