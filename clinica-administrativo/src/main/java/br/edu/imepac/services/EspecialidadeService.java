package br.edu.imepac.services;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.models.EspecialidadeModel;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<EspecialidadeDto> getAllEspecialidades() {
        List<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return especialidades.stream().map(especialidade -> {
            EspecialidadeDto dto = new EspecialidadeDto();
            dto.setId(especialidade.getId());
            dto.setNome(especialidade.getNome());
            dto.setDescricao(especialidade.getDescricao());
            return dto;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        especialidadeRepository.deleteById(id);
    }

    public List<EspecialidadeDto> findAll() {
        List<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return especialidades.stream().map(especialidade -> {
            EspecialidadeDto especialidadeDto = new EspecialidadeDto();
            especialidadeDto.setId(especialidade.getId());
            especialidadeDto.setNome(especialidade.getNome());
            especialidadeDto.setDescricao(especialidade.getDescricao());
            return especialidadeDto;
        }).collect(Collectors.toList());
    }

    public EspecialidadeDto update(Long id, EspecialidadeDto especialidadeDetails) {
        Optional<EspecialidadeModel> optionalEspecialidade = especialidadeRepository.findById(id);

        if (optionalEspecialidade.isPresent()) {
            EspecialidadeModel especialidadeModel = optionalEspecialidade.get();
            especialidadeModel.setNome(especialidadeDetails.getNome());
            especialidadeModel.setDescricao(especialidadeDetails.getDescricao());

            EspecialidadeModel updatedEspecialidade = especialidadeRepository.save(especialidadeModel);

            EspecialidadeDto especialidadeDto = new EspecialidadeDto();
            especialidadeDto.setId(updatedEspecialidade.getId());
            especialidadeDto.setNome(updatedEspecialidade.getNome());
            especialidadeDto.setDescricao(updatedEspecialidade.getDescricao());

            return especialidadeDto;
        } else {
            return null;
        }
    }

    public EspecialidadeDto findById(Long id) {
        Optional<EspecialidadeModel> optionalEspecialidade = especialidadeRepository.findById(id);

        if (optionalEspecialidade.isPresent()) {
            EspecialidadeModel especialidadeModel = optionalEspecialidade.get();
            EspecialidadeDto especialidadeDto = new EspecialidadeDto();
            especialidadeDto.setId(especialidadeModel.getId());
            especialidadeDto.setNome(especialidadeModel.getNome());
            especialidadeDto.setDescricao(especialidadeModel.getDescricao());
            return especialidadeDto;
        } else {
            return null;
        }
    }
}