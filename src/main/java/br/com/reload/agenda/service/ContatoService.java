package br.com.reload.agenda.service;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()) {
            return contatoOptional.get();
        }
        return null;
    }

    public void removerContatoPorId(Long id) {
        repository.deleteById(id);
    }

    public Contato editarContato(Long id, Contato contato) {
        Contato contatoSalvo = repository.findById(id).get();
        if (contatoSalvo.getId() == null) {
            return new Contato();
        }
        BeanUtils.copyProperties(contato, contatoSalvo, "id");
        return repository.save(contatoSalvo);
    }

    public List<Contato> buscarContatosPorParteDoNome(String nome) {
        return repository.findByNome("%" + nome + "%");
    }

}
