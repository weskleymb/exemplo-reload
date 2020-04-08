package br.com.reload.agenda.resource;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Contato salva(@RequestBody Contato contato) {
        return service.salva(contato);
    }

    @GetMapping("{id}")
    public Contato buscarPeloId(@PathVariable Long id) {
        try {
            return service.buscaPorId(id);
        } catch (Exception e) {
            return new Contato();
        }
    }

    @DeleteMapping("{id}")
    public void removerContatoPorId(@PathVariable Long id) {
        service.removerContatoPorId(id);
    }

    @PutMapping("{id}")
    public Contato editarContato(@PathVariable Long id, @RequestBody Contato contatoNovo) {
        return service.editarContato(id, contatoNovo);
    }

}
