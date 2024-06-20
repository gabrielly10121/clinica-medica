package br.edu.imepac.services;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {
    @Autowired
    private ConvenioRepository convenioRepository;

    public ConvenioDto createConvenio(ConvenioCreateRequest request) {
        ConvenioModel convenio = new ConvenioModel();
        convenio.setNome(request.getNome());
        convenio.setCodigo(request.getCodigo());
        convenio.setTipo(request.getTipo());
        convenio.setDescricao(request.getDescricao());
        convenio.setTelefone(request.getTelefone());
        convenio.setEmail(request.getEmail());
        convenio.setEndereco(request.getEndereco());

        ConvenioModel savedConvenio = convenioRepository.save(convenio);

        ConvenioDto convenioDto = new ConvenioDto();
        convenioDto.setId(savedConvenio.getId());
        convenioDto.setNome(savedConvenio.getNome());
        convenioDto.setCodigo(savedConvenio.getCodigo());
        convenioDto.setTipo(savedConvenio.getTipo());
        convenioDto.setDescricao(savedConvenio.getDescricao());
        convenioDto.setTelefone(savedConvenio.getTelefone());
        convenioDto.setEmail(savedConvenio.getEmail());
        convenioDto.setEndereco(savedConvenio.getEndereco());

        return convenioDto;
    }

    public List<ConvenioDto> getAllConvenios() {
        List<ConvenioModel> convenios = convenioRepository.findAll();
        return convenios.stream().map(convenio -> {
            ConvenioDto dto = new ConvenioDto();
            dto.setId(convenio.getId());
            dto.setNome(convenio.getNome());
            dto.setCodigo(convenio.getCodigo());
            dto.setTipo(convenio.getTipo());
            dto.setDescricao(convenio.getDescricao());
            dto.setTelefone(convenio.getTelefone());
            dto.setEmail(convenio.getEmail());
            dto.setEndereco(convenio.getEndereco());
            return dto;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        convenioRepository.deleteById(id);
    }

    public ConvenioDto update(Long id, ConvenioDto convenioDetails) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);
        if (optionalConvenio.isPresent()) {
            ConvenioModel convenio = optionalConvenio.get();
            convenio.setNome(convenioDetails.getNome());
            convenio.setCodigo(convenioDetails.getCodigo());
            convenio.setTipo(convenioDetails.getTipo());
            convenio.setDescricao(convenioDetails.getDescricao());
            convenio.setTelefone(convenioDetails.getTelefone());
            convenio.setEmail(convenioDetails.getEmail());
            convenio.setEndereco(convenioDetails.getEndereco());

            ConvenioModel updatedConvenio = convenioRepository.save(convenio);

            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(updatedConvenio.getId());
            convenioDto.setNome(updatedConvenio.getNome());
            convenioDto.setCodigo(updatedConvenio.getCodigo());
            convenioDto.setTipo(updatedConvenio.getTipo());
            convenioDto.setDescricao(updatedConvenio.getDescricao());
            convenioDto.setTelefone(updatedConvenio.getTelefone());
            convenioDto.setEmail(updatedConvenio.getEmail());
            convenioDto.setEndereco(updatedConvenio.getEndereco());

            return convenioDto;
        } else {
            return null;
        }
    }

    public ConvenioDto findById(Long id) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);
        if (optionalConvenio.isPresent()) {
            ConvenioModel convenio = optionalConvenio.get();
            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(convenio.getId());
            convenioDto.setNome(convenio.getNome());
            convenioDto.setCodigo(convenio.getCodigo());
            convenioDto.setTipo(convenio.getTipo());
            convenioDto.setDescricao(convenio.getDescricao());
            convenioDto.setTelefone(convenio.getTelefone());
            convenioDto.setEmail(convenio.getEmail());
            convenioDto.setEndereco(convenio.getEndereco());
            return convenioDto;
        } else {
            return null;
        }
    }
}