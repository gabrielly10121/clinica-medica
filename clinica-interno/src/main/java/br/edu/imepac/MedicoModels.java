package br.edu.imepac;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medico")
@Data
public class MedicoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String crm;
    private String senha;
}
