package br.com.reload.agenda.repository;

import br.com.reload.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
