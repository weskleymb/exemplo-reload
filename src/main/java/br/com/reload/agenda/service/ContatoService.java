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

}
