package br.edu.imepac.Dtos;
import lombok.Data;

@Data
public class AgendamentoConsultasDto { private int registro;
    private int codigoPaciente;
    private int codigoMedico;
    private String dataConsulta;
    private String horaConsulta;
    private String retornoConsulta;
    private String consultaCancelada;
    private String motivoCancelamento;

}
