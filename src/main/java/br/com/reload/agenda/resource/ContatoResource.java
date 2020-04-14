package br.com.reload.agenda.resource;

import br.com.reload.agenda.model.Contato;
import br.com.reload.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> listaContatos() {
        List<Contato> contatos = service.buscaTodos();

        if (contatos == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(contatos);
    }

    @PostMapping
    public ResponseEntity<Contato> salva(@RequestBody Contato contato) {
        Contato contatoSalvo = service.salva(contato);

        final ServletUriComponentsBuilder currentRequestUri = ServletUriComponentsBuilder.fromCurrentRequestUri();
        final UriComponentsBuilder path = currentRequestUri.path("/{id}");
        final UriComponents uriComponents = path.buildAndExpand(contatoSalvo.getId());
        final URI uri = uriComponents.toUri();

        return ResponseEntity.created(uri).body(contatoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPeloId(@PathVariable Long id) {
        Contato contato = service.buscaPorId(id);

        if (contato == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(contato);
    }

    @DeleteMapping("/{id}")
    public void removerContatoPorId(@PathVariable Long id) {
        service.removerContatoPorId(id);
    }

    @PutMapping("/{id}")
    public Contato editarContato(@PathVariable Long id, @RequestBody Contato contatoNovo) {
        return service.editarContato(id, contatoNovo);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Contato>> buscarContatosPorParteDoNome(@PathVariable("nome") String nome) {
        List<Contato> contatos = service.buscarContatosPorParteDoNome(nome);

        if (contatos == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(contatos);
    }

}
