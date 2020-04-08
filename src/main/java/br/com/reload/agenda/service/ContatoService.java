package br.com.reload.agenda.service;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> buscaTodos() {
        return repository.findAll();
    }

    public Contato salva(Contato contato) {
        return repository.save(contato);
    }

    public Contato buscaPorId(Long id) {
        return repository.findById(id).get();
    }

    public void removerContatoPorId(Long id) {
        repository.deleteById(id);
    }

    public Contato editarContato(Long id, Contato contatoNovo) {
        Contato contatoVelho = repository.findById(id).get();

        if (contatoVelho.getId() == null) {
            return new Contato();
        }
        contatoVelho.setNome(contatoNovo.getNome());
        contatoVelho.setFone(contatoNovo.getFone());
        contatoVelho.setEmail(contatoNovo.getEmail());
        return repository.save(contatoVelho);
    }
}
