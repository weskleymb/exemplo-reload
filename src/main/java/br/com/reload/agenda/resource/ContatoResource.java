package br.com.reload.agenda.resource;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @GetMapping
    public List<Contato> listaContatos() {
        return service.buscaTodos();
    }

}
