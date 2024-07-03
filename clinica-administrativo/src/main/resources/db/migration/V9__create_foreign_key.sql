-- Criação da tabela PacienteModel
CREATE TABLE IF NOT EXISTS paciente_model (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255),
    data_nascimento DATE,
    email VARCHAR(255),
    telefone VARCHAR(255)
);

-- Criação da tabela MedicoModel
CREATE TABLE IF NOT EXISTS medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    crm VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    especialidade_id BIGINT NOT NULL,
    CONSTRAINT fk_especialidade FOREIGN KEY (especialidade_id) REFERENCES especialidade(id)
);

-- Criação da tabela AgendamentoConsultasModel com chaves estrangeiras para PacienteModel e MedicoModel
CREATE TABLE IF NOT EXISTS clinica_medica.agendamento_consultas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    data_consulta DATE NOT NULL,
    hora_consulta TIME NOT NULL,
    consulta_cancelada VARCHAR(255),
    motivo_cancelamento VARCHAR(255),
    retorno_consulta VARCHAR(255),
    CONSTRAINT fk_paciente FOREIGN KEY (paciente_id) REFERENCES paciente_model(id),
    CONSTRAINT fk_medico FOREIGN KEY (medico_id) REFERENCES medicos(id)
);