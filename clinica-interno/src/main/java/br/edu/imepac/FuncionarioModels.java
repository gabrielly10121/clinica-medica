package br.edu.imepac;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class FuncionarioModels {
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
