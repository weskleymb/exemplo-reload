package br.com.reload.agenda;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApplication {

	@Autowired
	private static ContatoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
//		insereContatos();
	}

	public static void insereContatos() {
		Contato contato1 = new Contato();
		contato1.setNome("Weskley");
		contato1.setFone("2222-3333");
		contato1.setEmail("weskleymb@hotmail.com");

		repository.save(contato1);

		Contato contato2 = new Contato();
		contato2.setNome("João");
		contato2.setFone("4444-9999");
		contato2.setEmail("joao@email.com");

		repository.save(contato2);
	}

}
