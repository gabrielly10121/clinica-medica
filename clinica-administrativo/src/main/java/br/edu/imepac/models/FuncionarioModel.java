package br.edu.imepac.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
