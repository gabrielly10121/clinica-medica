package br.edu.imepac.services;

import br.edu.imepac.dtos.MedicoCreateRequest;
import br.edu.imepac.dtos.MedicoDto;
import br.edu.imepac.models.MedicoModel;
import br.edu.imepac.repositories.MedicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private static final Logger logger = LoggerFactory.getLogger(MedicoService.class);

    @Autowired
    private MedicoRepository medicoRepository;

    public void delete(Long id) {
        logger.info("Deleting Medico with id: {}", id);
        medicoRepository.deleteById(id);
    }

    public List<MedicoDto> findAll() {
        logger.info("Fetching all Medicos");
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicos.stream().map(medico -> {
            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(medico.getId());
            medicoDto.setNome(medico.getNome());
            medicoDto.setCrm(medico.getCrm());
            return medicoDto;
        }).collect(Collectors.toList());
    }

    public MedicoDto update(Long id, MedicoDto medicoDetails) {
        logger.info("Updating Medico with id: {}", id);
        Optional<MedicoModel> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            MedicoModel medicoModel = optionalMedico.get();
            medicoModel.setNome(medicoDetails.getNome());
            medicoModel.setCrm(medicoDetails.getCrm());
            MedicoModel updatedMedico = medicoRepository.save(medicoModel);
            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(updatedMedico.getId());
            medicoDto.setNome(updatedMedico.getNome());
            medicoDto.setCrm(updatedMedico.getCrm());
            return medicoDto;
        } else {
            logger.error("Medico with id: {} not found", id);
            return null;
        }
    }

    public MedicoDto save(MedicoCreateRequest medicoRequest) {
        logger.info("Saving new Medico with nome: {}", medicoRequest.getNome());
        MedicoModel medicoModel = new MedicoModel();
        medicoModel.setNome(medicoRequest.getNome());
        medicoModel.setCrm(medicoRequest.getCrm());
        medicoModel.setSenha(medicoRequest.getSenha());
        MedicoModel savedMedico = medicoRepository.save(medicoModel);
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId(savedMedico.getId());
        medicoDto.setNome(savedMedico.getNome());
        medicoDto.setCrm(savedMedico.getCrm());
        return medicoDto;
    }

    public MedicoDto findById(Long id) {
        logger.info("Finding Medico with id: {}", id);
        Optional<MedicoModel> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            MedicoModel medicoModel = optionalMedico.get();
            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(medicoModel.getId());
            medicoDto.setNome(medicoModel.getNome());
            medicoDto.setCrm(medicoModel.getCrm());
            return medicoDto;
        } else {
            logger.error("Medico with id: {} not found", id);
            return null;
        }
    }
}