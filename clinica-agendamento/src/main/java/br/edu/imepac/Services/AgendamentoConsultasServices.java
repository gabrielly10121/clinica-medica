package br.edu.imepac.Services;

import br.edu.imepac.Dtos.AgendamentoConsultasCreateRequest;
import br.edu.imepac.Dtos.AgendamentoConsultasDto;
import br.edu.imepac.Model.AgendamentoConsultasModel;
import br.edu.imepac.Repositories.AgendamentoConsultasRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoConsultasServices {

    @Autowired
    private AgendamentoConsultasRepositories repository;

    public List<AgendamentoConsultasDto> findAll() {
        List<AgendamentoConsultasModel> consultas = repository.findAll();
        return consultas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AgendamentoConsultasDto findById(Long id) {
        Optional<AgendamentoConsultasModel> consulta = repository.findById(id);
        return consulta.map(this::convertToDto).orElse(null);
    }

    public AgendamentoConsultasDto agendarConsulta(AgendamentoConsultasCreateRequest request) {
        AgendamentoConsultasModel consulta = convertToModel(request);
        AgendamentoConsultasModel savedConsulta = repository.save(consulta);
        return convertToDto(savedConsulta);
    }

    public AgendamentoConsultasDto cancelarConsulta(Long id, String motivoCancelamento) {
        Optional<AgendamentoConsultasModel> consulta = repository.findById(id);
        if (consulta.isPresent()) {
            AgendamentoConsultasModel consultaModel = consulta.get();
            consultaModel.setConsultaCancelada("Sim");
            consultaModel.setMotivoCancelamento(motivoCancelamento);
            AgendamentoConsultasModel updatedConsulta = repository.save(consultaModel);
            return convertToDto(updatedConsulta);
        }
        return null;
    }

    public AgendamentoConsultasDto registrarRetorno(Long id, String data, String hora) {
        Optional<AgendamentoConsultasModel> consulta = repository.findById(id);
        if (consulta.isPresent()) {
            AgendamentoConsultasModel consultaModel = consulta.get();
            consultaModel.setRetornoConsulta("Sim");
            consultaModel.setDataConsulta(data);
            consultaModel.setHoraConsulta(hora);
            AgendamentoConsultasModel updatedConsulta = repository.save(consultaModel);
            return convertToDto(updatedConsulta);
        }
        return null;
    }

    private AgendamentoConsultasDto convertToDto(AgendamentoConsultasModel model) {
        AgendamentoConsultasDto dto = new AgendamentoConsultasDto();
        return dto;
    }

    private AgendamentoConsultasModel convertToModel(AgendamentoConsultasCreateRequest request) {
        AgendamentoConsultasModel model = new AgendamentoConsultasModel();
        return model;
    }
}