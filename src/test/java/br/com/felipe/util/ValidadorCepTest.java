/**
 * 
 */
package br.com.felipe.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Felipe Zanardo Affonso
 *
 */
public class ValidadorCepTest {

	@Test
	public void deveRetornarTrueParaCepValido() {
		assertTrue(ValidadorCep.isCepValido("09530240"));
	}
	
	@Test
	public void deveRetornarFalseParaCepFaltandoUmCaracter() {
		assertFalse(ValidadorCep.isCepValido("0953024"));
	}
	
	@Test
	public void deveRetornarFalseParaCepComString() {
		assertFalse(ValidadorCep.isCepValido("0953024q"));
	}
	
	@Test
	public void deveRetornarFalseParaCepComTraco() {
		assertFalse(ValidadorCep.isCepValido("09530-240"));
	}

}
