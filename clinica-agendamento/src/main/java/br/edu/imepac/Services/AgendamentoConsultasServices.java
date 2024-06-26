package br.edu.imepac.Services;

import br.edu.imepac.Model.AgendamentoConsultasModel;
import br.edu.imepac.Repositories.AgendamentoConsultasRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoConsultasServices {@Autowired
private AgendamentoConsultasRepositories repository;

    public List<AgendamentoConsultasModel> findAll() {
        return repository.findAll();
    }

    public AgendamentoConsultasModel save(AgendamentoConsultasModel consulta) {
        return repository.save(consulta);
    }

    public void deleteById(int id) {
        repository.deleteById((long) id);
    }
}

