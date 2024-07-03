package br.edu.imepac.Model;


import br.edu.imepac.models.MedicoModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agendamento_consultas")
@Data
public class AgendamentoConsultasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoModel medico;


    private String dataConsulta;
    private String horaConsulta;
    private String consultaCancelada;
    private String motivoCancelamento;
    private String retornoConsulta;
}