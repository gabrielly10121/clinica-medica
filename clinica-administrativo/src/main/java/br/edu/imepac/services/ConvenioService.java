package br.edu.imepac.services;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.repositories.ConvenioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {
    private static final Logger logger = LoggerFactory.getLogger(ConvenioService.class);

    @Autowired
    private ConvenioRepository convenioRepository;

    public ConvenioDto createConvenio(ConvenioCreateRequest request) {
        logger.info("Creating new convenio with nome: {}", request.getNome());
        ConvenioModel convenio = new ConvenioModel();
        convenio.setNome(request.getNome());
        convenio.setCodigo(request.getCodigo());
        convenio.setTipo(request.getTipo());
        convenio.setDescricao(request.getDescricao());
        convenio.setTelefone(request.getTelefone());
        convenio.setEmail(request.getEmail());
        convenio.setEndereco(request.getEndereco());

        ConvenioModel savedConvenio = convenioRepository.save(convenio);
        logger.info("Convenio created with id: {}", savedConvenio.getId());

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
        logger.info("Fetching all convenios");
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
        logger.info("Deleting convenio with id: {}", id);
        convenioRepository.deleteById(id);
    }

    public ConvenioDto update(Long id, ConvenioDto convenioDetails) {
        logger.info("Updating convenio with id: {}", id);
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
            logger.info("Convenio updated with id: {}", updatedConvenio.getId());

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
            logger.error("Convenio with id: {} not found", id);
            return null;
        }
    }

    public ConvenioDto findById(Long id) {
        logger.info("Fetching convenio with id: {}", id);
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
            logger.error("Convenio with id: {} not found", id);
            return null;
        }
    }
}