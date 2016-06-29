/**
 * 
 */
package br.com.felipe.util;

import org.apache.commons.lang3.StringUtils;

import br.com.felipe.exception.CepInvalidoException;

/**
 * @author Felipe Zanardo Affonso
 *
 */
public class GeradorCep {

	public static String getNovoCep(String cep) {
		String cepAntigo = cep.replace("-", "");
		if(cepAntigo.equals("00000000")){
			throw new CepInvalidoException();
		}
		
		while(cepAntigo.charAt(cepAntigo.length() - 1) == '0') {
			cepAntigo = StringUtils.removeEnd(cepAntigo, "0");
		}
		String novoCep = cepAntigo.substring(0, cepAntigo.length() - 1);
		novoCep = StringUtils.rightPad(novoCep, 8, '0');
		if(novoCep.equals("00000000")){
			throw new CepInvalidoException();
		}
		return novoCep;
	}
}
