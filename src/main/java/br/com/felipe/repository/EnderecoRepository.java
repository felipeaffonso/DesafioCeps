/**
 * 
 */
package br.com.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.model.Endereco;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}