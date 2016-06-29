/**
 * 
 */
package br.com.felipe.controller;

import java.nio.charset.Charset;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.felipe.DesafioCepsApplication;
import br.com.felipe.util.TestAux;

/**
 * @author Felipe Zanardo Affonso
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DesafioCepsApplication.class)
@WebAppConfiguration
public class CepControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaPorCepValido() throws Exception{
		String numero = "09530240";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.equalTo(1)))
			.andExpect(MockMvcResultMatchers.jsonPath("cep", Matchers.equalTo("09530240")))
			.andExpect(MockMvcResultMatchers.jsonPath("rua", Matchers.equalTo("Rua Rui Barbosa")))
			.andExpect(MockMvcResultMatchers.jsonPath("bairro", Matchers.equalTo("Santo Antônio")))
			.andExpect(MockMvcResultMatchers.jsonPath("cidade", Matchers.equalTo("São Caetano do Sul")))
			.andExpect(MockMvcResultMatchers.jsonPath("estado", Matchers.equalTo("São Paulo")));
		
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaPorCepPorProximidade() throws Exception{
		String numero = "09534444";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.equalTo(2)))
			.andExpect(MockMvcResultMatchers.jsonPath("cep", Matchers.equalTo("09530000")))
			.andExpect(MockMvcResultMatchers.jsonPath("rua", Matchers.equalTo("Rua Major Carlos Del Prete")))
			.andExpect(MockMvcResultMatchers.jsonPath("bairro", Matchers.equalTo("Centro")))
			.andExpect(MockMvcResultMatchers.jsonPath("cidade", Matchers.equalTo("São Caetano do Sul")))
			.andExpect(MockMvcResultMatchers.jsonPath("estado", Matchers.equalTo("São Paulo")));
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaCepComOitoDigitos() throws Exception {
		String numero = "0953444";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isNotFound())
			.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaCepComLetras() throws Exception {
		String numero = "09534a12";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isNotFound())
			.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaCepComTodosCaracteresZerados() throws Exception {
		String numero = "00000000";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isNotFound())
			.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCepPost(br.com.felipe.controller.BuscaCepRequest)}.
	 */
	@Test
	public void pesquisaCepInexistente() throws Exception {
		String numero = "44441000";
	    String requestJson = TestAux.objetoParaJson(getBuscaEnderecoRequest(numero));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cep/busca")
			.accept(APPLICATION_JSON_UTF8)
			.contentType(APPLICATION_JSON_UTF8)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isNotFound())
			.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaPorCepValidoGet() throws Exception{
		String numero = "09530240";
		this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
			.accept(APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.equalTo(1)))
			.andExpect(MockMvcResultMatchers.jsonPath("cep", Matchers.equalTo("09530240")))
			.andExpect(MockMvcResultMatchers.jsonPath("rua", Matchers.equalTo("Rua Rui Barbosa")))
			.andExpect(MockMvcResultMatchers.jsonPath("bairro", Matchers.equalTo("Santo Antônio")))
			.andExpect(MockMvcResultMatchers.jsonPath("cidade", Matchers.equalTo("São Caetano do Sul")))
			.andExpect(MockMvcResultMatchers.jsonPath("estado", Matchers.equalTo("São Paulo")));
		
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaPorCepPorProximidadeGet() throws Exception{
		String numero = "09534444";
		this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
				.accept(APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.equalTo(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("cep", Matchers.equalTo("09530000")))
				.andExpect(MockMvcResultMatchers.jsonPath("rua", Matchers.equalTo("Rua Major Carlos Del Prete")))
				.andExpect(MockMvcResultMatchers.jsonPath("bairro", Matchers.equalTo("Centro")))
				.andExpect(MockMvcResultMatchers.jsonPath("cidade", Matchers.equalTo("São Caetano do Sul")))
				.andExpect(MockMvcResultMatchers.jsonPath("estado", Matchers.equalTo("São Paulo")));
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaCepComOitoDigitosGet() throws Exception {
		String numero = "0953444";
		this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
				.accept(APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaCepComLetrasGet() throws Exception {
		String numero = "09534a12";
		this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
				.accept(APPLICATION_JSON_UTF8))
	   			.andExpect(MockMvcResultMatchers.status().isNotFound())
	   			.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaCepComTodosCaracteresZeradosGet() throws Exception {
		String numero = "00000000";
	    this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
				.accept(APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Test method for {@link br.com.felipe.controller.CepController#getEnderecoPorNumeroCep(java.lang.String)}.
	 */
	@Test
	public void pesquisaCepInexistenteGet() throws Exception {
		String numero = "44441000";
		this.mockMvc.perform(MockMvcRequestBuilders.get(String.format("/cep/%s", numero))
				.accept(APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	private BuscaCepRequest getBuscaEnderecoRequest(String numero) {
		BuscaCepRequest request = new BuscaCepRequest();
		request.setCep(numero);
		return request;
	}
}
