package br.edu.imepac.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AgendamentoConsultasModel{
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