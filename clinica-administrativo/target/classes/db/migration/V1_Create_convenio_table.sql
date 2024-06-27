CREATE TABLE convenio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255),
    tipo VARCHAR(255),
    descricao VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255)
);