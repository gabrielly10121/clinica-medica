-- Criação da tabela EspecialidadeModel
CREATE TABLE IF NOT EXISTS especialidade (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
);

-- Criação da tabela MedicoModel com chave estrangeira para EspecialidadeModel
CREATE TABLE IF NOT EXISTS medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    crm VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    especialidade_id BIGINT NOT NULL,
    CONSTRAINT fk_especialidade FOREIGN KEY (especialidade_id) REFERENCES especialidade(id)
);