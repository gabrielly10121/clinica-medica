package br.edu.imepac;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "especialidade")
@Data
public class EspecialidadeModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String descricao;
}
