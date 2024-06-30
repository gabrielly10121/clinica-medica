CREATE TABLE agendamento_consultas (
registro INT AUTO_INCREMENT PRIMARY KEY,
    codigo_paciente INT NOT NULL,
    codigo_medico INT NOT NULL,
    data_consulta DATE NOT NULL,
    hora_consulta TIME NOT NULL,
    retorno_consulta VARCHAR(255),
    consulta_cancelada VARCHAR(255),
    motivo_cancelamento VARCHAR(255)
);