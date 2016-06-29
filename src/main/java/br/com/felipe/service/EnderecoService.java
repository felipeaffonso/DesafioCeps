/**
 * 
 */
package br.com.felipe.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.felipe.exception.CepInvalidoException;
import br.com.felipe.model.Endereco;
import br.com.felipe.repository.EnderecoRepository;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@Service
@Validated
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CepService cepService;
	
	public Optional<Endereco> buscaPorId(final Long id) {
		return Optional.ofNullable(this.enderecoRepository.findOne(id));
	}
	
	@Transactional
	public Endereco salva(final Endereco endereco) {
		if(this.cepService.verificaCepExiste(endereco.getCep())) {
			return this.enderecoRepository.save(endereco);
		}else {
			throw new CepInvalidoException();
		}
	}
	
	@Transactional
	public void apaga(final Long id) {
		this.enderecoRepository.delete(id);
	}
	
	public java.util.List<Endereco> buscaTodos() {
		return this.enderecoRepository.findAll();
	}
	
}