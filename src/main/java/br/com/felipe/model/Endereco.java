package br.com.felipe.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidade que representa um endereço.
 * @author Felipe Zanardo Affonso
 *
 */
@Entity(name="ENDERECO")
public class Endereco implements Serializable{
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3479671885913243832L;

	@Id
	@GeneratedValue
	@Column(name = "ID_ENDERECO")
	private Long id;
	
	@NotNull(message = "O campo CEP é obrigatório.")
	@Column(nullable=false, name = "NR_CEP")
	private String cep;
	
	@Size(min=5, max=200, message="O campo Logradouro aceita entre 5 e 200 caractéres.")
	@NotNull(message = "O campo Rua é obrigatório.")
	@Column(nullable=false, name = "NM_RUA")
	private String rua;
	
	@Size(min=1, max=8, message = "O campo Número aceita entre 1 e 8 caractéres.")
	@NotNull(message = "O campo Número é obrigatório.")
	@Column(nullable=false, name = "NR_NUMERO")
	private String numero;
	
	@Column(name = "NM_COMPLEMENTO")
	private String complemento;
	
	@Column(name = "NM_BAIRRO")
	private String bairro;
	
	@Size(min=2, max=200, message="O campo Cidade aceita entre 2 e 200 caractéres.")
	@NotNull(message = "O campo Cidade é obrigatório.")
	@Column(nullable=false, name = "NM_CIDADE")
	private String cidade;
	
	@Size(min=2, max=200, message="O campo Estado aceita entre 2 e 200 caractéres.")
	@NotNull(message="O campo Estado é obrigatório.")
	@Column(nullable=false, name = "NM_ESTADO")
	private String estado;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}