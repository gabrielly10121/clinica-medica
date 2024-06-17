package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ConvenioCreateRequest {
    private String nome;
    private String codigo;
    private String tipo;
    private String descricao;
    private String telefone;
    private String email;
    private String endereco;
}
