package br.edu.imepac.services;

import br.edu.imepac.dtos.ProntuarioCreateRequest;
import br.edu.imepac.dtos.ProntuarioDto;
import br.edu.imepac.models.ProntuarioModel;
import br.edu.imepac.repositories.ProntuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProntuarioService {

    private static final Logger logger = LoggerFactory.getLogger(ProntuarioService.class);

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public ProntuarioDto createProntuario(ProntuarioCreateRequest request) {
        logger.info("Creating new prontuario with codigoPaciente: {}", request.getCodigoPaciente());
        ProntuarioModel prontuario = new ProntuarioModel();
        prontuario.setCodigoPaciente(request.getCodigoPaciente());
        prontuario.setHistorico(request.getHistorico());
        prontuario.setReceituario(request.getReceituario());
        prontuario.setExame(request.getExame());
        prontuario = prontuarioRepository.save(prontuario);
        logger.info("Prontuario created with registroAgenda: {}", prontuario.getRegistroAgenda());
        return toDto(prontuario);
    }

    public List<ProntuarioDto> getAllProntuarios() {
        logger.info("Fetching all prontuarios");
        return prontuarioRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProntuarioDto getProntuarioById(Long id) {
        logger.info("Fetching prontuario with id: {}", id);
        Optional<ProntuarioModel> prontuario = prontuarioRepository.findById(id);
        return prontuario.map(this::toDto).orElse(null);
    }

    public ProntuarioDto updateProntuario(Long id, ProntuarioCreateRequest request) {
        logger.info("Updating prontuario with id: {}", id);
        ProntuarioModel prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuario not found"));
        prontuario.setCodigoPaciente(request.getCodigoPaciente());
        prontuario.setHistorico(request.getHistorico());
        prontuario.setReceituario(request.getReceituario());
        prontuario.setExame(request.getExame());
        prontuario = prontuarioRepository.save(prontuario);
        logger.info("Prontuario updated with registroAgenda: {}", prontuario.getRegistroAgenda());
        return toDto(prontuario);
    }

    public void deleteProntuario(Long id) {
        logger.info("Deleting prontuario with id: {}", id);
        prontuarioRepository.deleteById(id);
    }

    private ProntuarioDto toDto(ProntuarioModel prontuario) {
        ProntuarioDto dto = new ProntuarioDto();
        dto.setRegistroAgenda(prontuario.getRegistroAgenda());
        dto.setCodigoPaciente(prontuario.getCodigoPaciente());
        dto.setHistorico(prontuario.getHistorico());
        dto.setReceituario(prontuario.getReceituario());
        dto.setExame(prontuario.getExame());
        return dto;
    }
}