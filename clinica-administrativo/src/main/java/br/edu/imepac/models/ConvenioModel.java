package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;


    @Entity
    @Table(name = "convenio")
    @Data

public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String codigo;
        private String tipo;
        private String descricao;
        private String telefone;
        private String email;
        private String endereco;

}
