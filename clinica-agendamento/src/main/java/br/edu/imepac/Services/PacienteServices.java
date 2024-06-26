package br.edu.imepac.Services;

import br.edu.imepac.Model.PacienteModel;
import br.edu.imepac.Repositories.PacienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServices {

    @Autowired
    private PacienteRepositories pacienteRepository;

    public List<PacienteModel> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public PacienteModel savePaciente(PacienteModel paciente) {
        return pacienteRepository.save(paciente);
    }

    public PacienteModel getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public PacienteModel updatePaciente(Long id, PacienteModel pacienteDetails) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            PacienteModel paciente = optionalPaciente.get();
            paciente.setNome(pacienteDetails.getNome());
            paciente.setSobrenome(pacienteDetails.getSobrenome());
            paciente.setDataNascimento(pacienteDetails.getDataNascimento());
            paciente.setEmail(pacienteDetails.getEmail());
            paciente.setTelefone(pacienteDetails.getTelefone());
            return pacienteRepository.save(paciente);
        } else {
            return null;
        }
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}