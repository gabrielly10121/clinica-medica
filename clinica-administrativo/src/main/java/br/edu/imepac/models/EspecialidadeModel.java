package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "especialidade")
@Data
public class EspecialidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String Descricao;
}
