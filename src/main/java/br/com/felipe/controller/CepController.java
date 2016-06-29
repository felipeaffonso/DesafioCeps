/**
 * 
 */
package br.com.felipe.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.exception.CepInvalidoException;
import br.com.felipe.model.Cep;
import br.com.felipe.service.CepService;
import br.com.felipe.util.GeradorCep;
import br.com.felipe.util.ValidadorCep;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@RestController
@RequestMapping(value = "/cep")
public class CepController {
	
	@Autowired
	private CepService cepService;

	@RequestMapping(value = "/busca", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Cep getEnderecoPorNumeroCepPost(@RequestBody BuscaCepRequest buscaEnderecoRequest) {
		if(!ValidadorCep.isCepValido(buscaEnderecoRequest.getCep())){
			throw new CepInvalidoException();
		}
		String numero = buscaEnderecoRequest.getCep();
		Optional<Cep> enderecoNullable = this.cepService.getCepPorNumero(numero);
		return enderecoNullable.isPresent() ? enderecoNullable.get() : this.getEnderecoPorNumeroCepPost(this.getEnderecoRequest(numero));
	}
	
	@RequestMapping(value = "/{numero}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Cep getEnderecoPorNumeroCep(@PathVariable String numero) {
		if(!ValidadorCep.isCepValido(numero)){
			throw new CepInvalidoException();
		}
		Optional<Cep> enderecoNullable = this.cepService.getCepPorNumero(numero);
		if(enderecoNullable.isPresent()) {
			return enderecoNullable.get();
		} else{
			String novoCep = GeradorCep.getNovoCep(numero);
			return this.getEnderecoPorNumeroCep(novoCep);
		}
	}

	/**
	 * @param numero
	 * @return
	 */
	private BuscaCepRequest getEnderecoRequest(String numero) {
		BuscaCepRequest request = new BuscaCepRequest();
		String novoCep = GeradorCep.getNovoCep(numero);
		request.setCep(novoCep);
		return request;
	}

	
}
