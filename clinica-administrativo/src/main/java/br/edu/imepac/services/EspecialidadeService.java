package br.edu.imepac.services;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.models.EspecialidadeModel;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeDto createEspecialidade(EspecialidadeCreateRequest request) {
        EspecialidadeModel especialidade = new EspecialidadeModel();
        especialidade.setNome(request.getNome());
        especialidade.setDescricao(request.getDescricao());

        EspecialidadeModel savedEspecialidade = especialidadeRepository.save(especialidade);

        EspecialidadeDto especialidadeDto = new EspecialidadeDto();
        especialidadeDto.setId(savedEspecialidade.getId());
        especialidadeDto.setNome(savedEspecialidade.getNome());
        especialidadeDto.setDescricao(savedEspecialidade.getDescricao());

        return especialidadeDto;
    }

    public List<EspecialidadeDto> getAllEspecialidades(){
        List<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return especialidades.stream().map(especialidade -> {
            EspecialidadeDto dto = new EspecialidadeDto();
            dto.setId(especialidade.getId());
            dto.setNome(especialidade.getNome());
            dto.setDescricao(especialidade.getDescricao());
            return dto;
        }).collect(Collectors.toList());

        }
    }
