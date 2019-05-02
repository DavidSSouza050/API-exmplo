package br.senai.sp.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senai.sp.api.model.Contato;
import br.senai.sp.api.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")// 
public class ContatoResource {
	@Autowired //← dizendo para o spring tomar contato desse atributo
	private ContatoRepository contatoRepository;
	
	@GetMapping //← mapiando o metodo como get 
	public List<Contato> getContatos(){
		return contatoRepository.findAll();
	}
	
	@PostMapping // ← mapiando para salvar o contato no banco
	//@ResponseStatus(HttpStatus.CREATED)   ↓ falando que o objeto esta vindo do nome
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato, HttpServletResponse response) {
		Contato contatoSalvo = contatoRepository.save(contato);
		URI uri = ServletUriComponentsBuilder
				  .fromCurrentRequestUri()
				  .path("/{id}")
				  .buildAndExpand(contatoSalvo.getId())
				  .toUri();
		response.addHeader("Location", uri.toASCIIString());
	
		return ResponseEntity.created(uri).body(contato);
	}
	
	@GetMapping("/{id}")// mapiando o pegando como verbo de de http
	public Optional<Contato> getContato(@PathVariable Long id) {
		return contatoRepository.findById(id);
	}
	
	@DeleteMapping("/{id}") // mapiando o delete como verbo de de http
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  deleteContato(@PathVariable Long id) {
		 contatoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")// mapiando o put (atualizar) como verbo de de http
	public ResponseEntity<Contato>  atualizarContato(@RequestBody Contato contato,@PathVariable Long id) {
		Contato contatoSalvo = contatoRepository.findById(id).get();// indo no repositório e pegando o id no banco
		BeanUtils.copyProperties(contato, contatoSalvo, "id");// pegando o contato vindo do body e colancando no repositório (contatoSalvo) e iguinorando o id
		contatoRepository.save(contato);// salvando no banco com id (lembre-se coloque o id no bory e não mexa nele)
		return ResponseEntity.ok(contatoSalvo);// devolvendo o registro atualizado no banco
	}

}








