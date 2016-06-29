/**
 * 
 */
package br.com.felipe.controller;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@XmlRootElement
public class BuscaCepRequest implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5229631276016895146L;
	
	@NotNull(message = "CEP é obrigatório.")
	private String cep;

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
		
}