package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class FuncionarioCreateRequest {
    private String nomeCompleto;
    private String rg;
    private String orgaoEmissor;
    private String cpf;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String sexo;
    private String dataNascimento;
}
