package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ProntuarioCreateRequest {
    private int codigoPaciente;
    private String historico;
    private String receituario;
    private String exame;
}
