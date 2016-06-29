/**
 * 
 */
package br.com.felipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Endereço não encontrado")
public class EnderecoNaoExisteException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5406399492120348937L;

}
