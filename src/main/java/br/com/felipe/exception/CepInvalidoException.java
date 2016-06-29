package br.com.felipe.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 */

/**
 * @author Felipe Zanardo Affonso
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "CEP inválido")
public class CepInvalidoException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5580488556556339197L;

}