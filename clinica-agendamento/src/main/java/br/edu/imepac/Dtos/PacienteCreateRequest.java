package br.edu.imepac.Dtos;

public class PacienteCreateRequest {
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String telefone;

    public String getDataNascimento() {
        return dataNascimento;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }
}