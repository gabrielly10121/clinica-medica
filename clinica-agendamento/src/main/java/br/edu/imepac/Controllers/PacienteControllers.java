package br.edu.imepac.Controllers;

import br.edu.imepac.Dtos.PacienteCreateRequest;
import br.edu.imepac.Model.PacienteModel;
import br.edu.imepac.Services.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteControllers {
    @Autowired
    private PacienteServices pacienteService;

    @GetMapping
    public List<PacienteModel> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping
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
    public PacienteModel getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}