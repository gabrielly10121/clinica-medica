package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;


    @Entity
    @Table(name = "convenio")
    @Data

public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String tipo;
    private String email;

}
