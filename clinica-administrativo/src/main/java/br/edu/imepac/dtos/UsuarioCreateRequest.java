package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class UsuarioCreateRequest {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
}
