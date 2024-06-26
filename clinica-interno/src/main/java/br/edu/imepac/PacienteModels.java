package br.edu.imepac;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paciente")
@Data
public class PacienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String telefone;
}
