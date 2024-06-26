package br.edu.imepac;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agendamentoConsulta")
@Data
public class AgendamentoConsultaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int registro;
    private int codigoPaciente;
    private int codigoMedico;
    private String dataConsulta;
    private String horaConsulta;
    private String retornoConsulta;
    private String consultaCancelada;
    private String motivoCancelamento;
}
