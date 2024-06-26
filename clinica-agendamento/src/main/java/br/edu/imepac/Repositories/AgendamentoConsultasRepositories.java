package br.edu.imepac.Repositories;
import br.edu.imepac.Model.AgendamentoConsultasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoConsultasRepositories extends JpaRepository<AgendamentoConsultasModel, Long>{
}
