package br.edu.imepac.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaAtendimento {
    private static final Logger logger = LoggerFactory.getLogger(ClinicaAtendimento.class);

    public static void main(String[] args) {
        SpringApplication.run(ClinicaAtendimento.class, args);
        logger.info("Aplicação ClinicaAtendimento iniciada com sucesso.");
        logger.debug("Este é um log de debug.");
        logger.error("Este é um log de erro.");
    }
}
