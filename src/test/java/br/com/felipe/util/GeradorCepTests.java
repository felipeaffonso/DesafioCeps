/**
 * 
 */
package br.com.felipe.util;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.felipe.exception.CepInvalidoException;

/**
 * @author Felipe Zanardo Affonso
 *
 */
public class GeradorCepTests {

	/**
	 * Test method for {@link br.com.felipe.util.GeradorCep#getNovoCep(java.lang.String)}.
	 */
	
	@Test
	public void deveFuncionarComNenhumZeroNaString() {
		String novoCep = GeradorCep.getNovoCep("99999999");
		assertEquals("99999990", novoCep);
	}
	
	@Test
	public void deveFuncionarComUmZeroNoFinal() {
		String novoCep = GeradorCep.getNovoCep("09530240");
		assertEquals("09530200", novoCep);
	}
	
	@Test
	public void deveFuncionarComDoisZerosNoFinal() {
		String novoCep = GeradorCep.getNovoCep("09530200");
		assertEquals("09530000", novoCep);
	}
	
	@Test
	public void deveFuncionarComSomenteUmZeroNoInicio() {
		String novoCep = GeradorCep.getNovoCep("09999999");
		assertEquals("09999990", novoCep);
	}
	
	@Test
	public void deveFuncionarComDoisZerosNoInicio() {
		String novoCep = GeradorCep.getNovoCep("00999999");
		assertEquals("00999990", novoCep);
	}
	
	@Test(expected = CepInvalidoException.class)
	public void deveLancarCepInvalidoExceptionQuandoTodosNumerosForemSubstituidosPorZero() throws Exception {
		GeradorCep.getNovoCep("90000000");
	}
	
	@Test(expected = CepInvalidoException.class)
	public void deveLancarCepInvalidoExceptionQuandoTodosOsDigitosForemZero() throws Exception {
		GeradorCep.getNovoCep("90000000");
	}

}
