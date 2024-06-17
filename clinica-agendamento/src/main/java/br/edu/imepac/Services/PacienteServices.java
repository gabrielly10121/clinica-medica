package br.edu.imepac.Services;
import br.edu.imepac.Model.PacienteModel;
import br.edu.imepac.Repositories.PacienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
