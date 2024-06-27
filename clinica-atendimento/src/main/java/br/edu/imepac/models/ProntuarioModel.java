package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prontuario")
@Data
public class ProntuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int registroAgenda;
    private int codigoPaciente;
    private String historico;
    private String receituario;
    private String exame;
}
