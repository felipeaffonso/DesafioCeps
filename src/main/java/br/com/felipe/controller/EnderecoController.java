/**
 * 
 */
package br.com.felipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.exception.EnderecoNaoExisteException;
import br.com.felipe.model.Endereco;
import br.com.felipe.service.EnderecoService;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	private List<Endereco> buscaTodosEnderecos() {
		return this.enderecoService.buscaTodos();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	private Endereco buscaEnderecoPorId(@PathVariable Long id) {
		Optional<Endereco> enderecoNullable = this.enderecoService.buscaPorId(id);
		if(enderecoNullable.isPresent()) {
			return enderecoNullable.get();
		}else {
			throw new EnderecoNaoExisteException();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private void apagaEnderecoPorId(@PathVariable Long id) {
		Optional<Endereco> enderecoNullable = this.enderecoService.buscaPorId(id);
		if(enderecoNullable.isPresent()) {
			this.enderecoService.apaga(id);
		}else {
			throw new EnderecoNaoExisteException();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Endereco salvaNovoEndereco(@RequestBody Endereco endereco) {
		return this.enderecoService.salva(endereco);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Endereco atualizaEndereco(@RequestBody Endereco endereco) {
		Optional<Endereco> enderecoNullable = this.enderecoService.buscaPorId(endereco.getId());
		if(enderecoNullable.isPresent()) {
			return this.enderecoService.salva(endereco);
		}else {
			throw new EnderecoNaoExisteException();
		}
	}

}
