package br.edu.imepac.repositories;

import br.edu.imepac.models.ProntuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<ProntuarioModel, Long> {
}