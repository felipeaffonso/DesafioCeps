/**
 * 
 */
package br.com.felipe.util;

/**
 * @author Felipe Zanardo Affonso
 *
 */
public class ValidadorCep {
	
	public static boolean isCepValido(String cep) {
		String padrao = "\\d{8}";
		return cep.matches(padrao);
	}

}
