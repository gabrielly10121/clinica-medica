package br.edu.imepac.services;

import br.edu.imepac.dtos.FuncionarioCreateRequest;
import br.edu.imepac.dtos.FuncionarioDto;
import br.edu.imepac.models.FuncionarioModel;
import br.edu.imepac.dtos.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDto createFuncionario(FuncionarioCreateRequest request) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNomeCompleto(request.getNomeCompleto());
        funcionario.setRg(request.getRg());
        funcionario.setOrgaoEmissor(request.getOrgaoEmissor());
        funcionario.setCpf(request.getCpf());
        funcionario.setEndereco(request.getEndereco());
        funcionario.setNumero(request.getNumero());
        funcionario.setBairro(request.getBairro());
        funcionario.setCidade(request.getCidade());
        funcionario.setEstado(request.getEstado());
        funcionario.setTelefone(request.getTelefone());
        funcionario.setSexo(request.getSexo());
        funcionario.setDataNascimento(request.getDataNascimento());

        FuncionarioModel savedFuncionario = funcionarioRepository.save(funcionario);

        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setId(savedFuncionario.getId());
        funcionarioDto.setNomeCompleto(savedFuncionario.getNomeCompleto());
        funcionarioDto.setRg(savedFuncionario.getRg());
        funcionarioDto.setOrgaoEmissor(savedFuncionario.getOrgaoEmissor());
        funcionarioDto.setCpf(savedFuncionario.getCpf());
        funcionarioDto.setEndereco(savedFuncionario.getEndereco());
        funcionarioDto.setNumero(savedFuncionario.getNumero());
        funcionarioDto.setBairro(savedFuncionario.getBairro());
        funcionarioDto.setCidade(savedFuncionario.getCidade());
        funcionarioDto.setEstado(savedFuncionario.getEstado());
        funcionarioDto.setTelefone(savedFuncionario.getTelefone());
        funcionarioDto.setSexo(savedFuncionario.getSexo());
        funcionarioDto.setDataNascimento(savedFuncionario.getDataNascimento());

        return funcionarioDto;
    }

    public List<FuncionarioDto> getAllFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> {
            FuncionarioDto dto = new FuncionarioDto();
            dto.setId(funcionario.getId());
            dto.setNomeCompleto(funcionario.getNomeCompleto());
            dto.setRg(funcionario.getRg());
            dto.setOrgaoEmissor(funcionario.getOrgaoEmissor());
            dto.setCpf(funcionario.getCpf());
            dto.setEndereco(funcionario.getEndereco());
            dto.setNumero(funcionario.getNumero());
            dto.setBairro(funcionario.getBairro());
            dto.setCidade(funcionario.getCidade());
            dto.setEstado(funcionario.getEstado());
            dto.setTelefone(funcionario.getTelefone());
            dto.setSexo(funcionario.getSexo());
            dto.setDataNascimento(funcionario.getDataNascimento());
            return dto;
        }).collect(Collectors.toList());
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDto update(Long id, FuncionarioDto funcionarioDetails) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funcionario = optionalFuncionario.get();
            funcionario.setNomeCompleto(funcionarioDetails.getNomeCompleto());
            funcionario.setRg(funcionarioDetails.getRg());
            funcionario.setOrgaoEmissor(funcionarioDetails.getOrgaoEmissor());
            funcionario.setCpf(funcionarioDetails.getCpf());
            funcionario.setEndereco(funcionarioDetails.getEndereco());
            funcionario.setNumero(funcionarioDetails.getNumero());
            funcionario.setBairro(funcionarioDetails.getBairro());
            funcionario.setCidade(funcionarioDetails.getCidade());
            funcionario.setEstado(funcionarioDetails.getEstado());
            funcionario.setTelefone(funcionarioDetails.getTelefone());
            funcionario.setSexo(funcionarioDetails.getSexo());
            funcionario.setDataNascimento(funcionarioDetails.getDataNascimento());

            FuncionarioModel updatedFuncionario = funcionarioRepository.save(funcionario);

            FuncionarioDto funcionarioDto = new FuncionarioDto();
            funcionarioDto.setId(updatedFuncionario.getId());
            funcionarioDto.setNomeCompleto(updatedFuncionario.getNomeCompleto());
            funcionarioDto.setRg(updatedFuncionario.getRg());
            funcionarioDto.setOrgaoEmissor(updatedFuncionario.getOrgaoEmissor());
            funcionarioDto.setCpf(updatedFuncionario.getCpf());
            funcionarioDto.setEndereco(updatedFuncionario.getEndereco());
            funcionarioDto.setNumero(updatedFuncionario.getNumero());
            funcionarioDto.setBairro(updatedFuncionario.getBairro());
            funcionarioDto.setCidade(updatedFuncionario.getCidade());
            funcionarioDto.setEstado(updatedFuncionario.getEstado());
            funcionarioDto.setTelefone(updatedFuncionario.getTelefone());
            funcionarioDto.setSexo(updatedFuncionario.getSexo());
            funcionarioDto.setDataNascimento(updatedFuncionario.getDataNascimento());

            return funcionarioDto;
        } else {
            return null;
        }
    }

    public FuncionarioDto findById(Long id) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funcionario = optionalFuncionario.get();
            FuncionarioDto funcionarioDto = new FuncionarioDto();
            funcionarioDto.setId(funcionario.getId());
            funcionarioDto.setNomeCompleto(funcionario.getNomeCompleto());
            funcionarioDto.setRg(funcionario.getRg());
            funcionarioDto.setOrgaoEmissor(funcionario.getOrgaoEmissor());
            funcionarioDto.setCpf(funcionario.getCpf());
            funcionarioDto.setEndereco(funcionario.getEndereco());
            funcionarioDto.setNumero(funcionario.getNumero());
            funcionarioDto.setBairro(funcionario.getBairro());
            funcionarioDto.setCidade(funcionario.getCidade());
            funcionarioDto.setEstado(funcionario.getEstado());
            funcionarioDto.setTelefone(funcionario.getTelefone());
            funcionarioDto.setSexo(funcionario.getSexo());
            funcionarioDto.setDataNascimento(funcionario.getDataNascimento());
            return funcionarioDto;
        } else {
            return null;
        }
    }

    public long countFuncionarios() {
        return funcionarioRepository.count();
    }
}