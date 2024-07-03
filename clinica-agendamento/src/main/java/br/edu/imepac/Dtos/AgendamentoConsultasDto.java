package br.edu.imepac.Dtos;

import lombok.Data;

@Data
public class AgendamentoConsultasDto {
    private Long id;
    private String nomePaciente;
    private String dataConsulta;
    private String horaConsulta;
    private String consultaCancelada;
    private String motivoCancelamento;
    private String retornoConsulta;

}