package br.edu.imepac.Repositories;

import br.edu.imepac.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositories extends JpaRepository<PacienteModel, Long> {
}
