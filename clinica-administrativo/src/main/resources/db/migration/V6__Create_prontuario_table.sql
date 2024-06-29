CREATE TABLE prontuario (
    registro_agenda INT AUTO_INCREMENT PRIMARY KEY,
    codigo_paciente INT NOT NULL,
    historico VARCHAR(255),
    receituario VARCHAR(255),
    exame VARCHAR(255)
);