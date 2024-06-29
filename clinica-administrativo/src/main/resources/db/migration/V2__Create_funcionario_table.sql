CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    rg VARCHAR(255),
    orgao_emissor VARCHAR(255),
    cpf VARCHAR(255),
    endereco VARCHAR(255),
    numero VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    telefone VARCHAR(255),
    sexo VARCHAR(255),
    data_nascimento VARCHAR(255)
);