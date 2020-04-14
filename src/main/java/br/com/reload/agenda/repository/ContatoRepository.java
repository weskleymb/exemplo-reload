package br.com.reload.agenda.repository;

import br.com.reload.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE c.nome LIKE %:nome%")
    List<Contato> findByNome(@Param("nome") String nome);

}
