/**
 * 
 */
package br.com.felipe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.felipe.model.Cep;
import br.com.felipe.repository.CepRepository;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@Service
@Validated
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CepService{
	
	@Autowired
	private CepRepository cepRepository;

	/**
	 * Busca um CEP pelo número.
	 * @param numero
	 * @return
	 */
	public Optional<Cep> getCepPorNumero(String numero) {
		Cep endereco = this.cepRepository.findByCep(numero);
		return Optional.ofNullable(endereco);
	}
	
	public boolean verificaCepExiste(String numero) {
		Optional<Cep> cepNullable = this.getCepPorNumero(numero);
		return cepNullable.isPresent();
	}

}
