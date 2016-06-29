/**
 * 
 */
package br.com.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.model.Cep;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

	public Cep findByCep(String cep);
}
