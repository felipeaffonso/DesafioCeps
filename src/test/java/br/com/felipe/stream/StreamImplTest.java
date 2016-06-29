/**
 * 
 */
package br.com.felipe.stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.felipe.stream.exception.NaoEncontrouCaracterNaoRepeteException;
import br.com.felipe.stream.exception.StreamEndException;



/**
 * @author Felipe Zanardo Affonso
 *
 */
public class StreamImplTest {

	/**
	 * Test method for {@link br.com.felipe.stream.StreamImpl#firstChar(br.com.felipe.stream.Stream)}.
	 */
	@Test
	public void deveRetornarBMinusculoComExemploEnunciado() {
		Stream teste = new StreamImpl("aAbBABac".toCharArray());
		char resultado = StreamImpl.firstChar(teste);
		assertTrue(resultado == 'b');
	}
	
	/**
	 * Test method for {@link br.com.felipe.stream.StreamImpl#firstChar(br.com.felipe.stream.Stream)}.
	 */
	@Test
	public void deveRetornarBMausculoComStringGrande() {
		Stream teste = new StreamImpl("aAbCAFac1231234412assasasd2a154dsssaBasas21121asas".toCharArray());
		char resultado = StreamImpl.firstChar(teste);
		assertTrue(resultado == 'b');
	}
	
	/**
	 * Test method for {@link br.com.felipe.stream.StreamImpl#firstChar(br.com.felipe.stream.Stream)}.
	 */
	@Test(expected = NaoEncontrouCaracterNaoRepeteException.class)
	public void deveLancarExceptionQuandoNaoEncontrarCaracterUnico() {
		Stream teste = new StreamImpl("AAAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCDDDDDDDDDDDDDD".toCharArray());
		StreamImpl.firstChar(teste);
	}
	
	@Test
	public void deveLerPrimeiroCaracterQuandoChamaGetNext() {
		Stream teste = new StreamImpl("A".toCharArray());
		Character resultado = teste.getNext();
		assertTrue(resultado == 'A');
	}
	
	@Test
	public void deveLerDoisCaracteresDiferentesQuandoChamaGetNextDuasVezes() {
		Stream teste = new StreamImpl("AB".toCharArray());
		Character resultadoA = teste.getNext();
		Character resultadoB = teste.getNext();
		assertTrue(resultadoA == 'A');
		assertTrue(resultadoB == 'B');
		assertFalse(resultadoA == resultadoB);
	}
	
	@Test
	public void deveLerDoisCaracteresIguaisQuandoChamaGetNextDuasVezes() {
		Stream teste = new StreamImpl("AA".toCharArray());
		Character resultadoA = teste.getNext();
		Character resultadoB = teste.getNext();
		assertTrue(resultadoA == 'A');
		assertTrue(resultadoB == 'A');
		assertTrue(resultadoA == resultadoB);
	}
	
	@Test(expected = StreamEndException.class)
	public void deveLancarStreamEndExceptionQuandoNaoHaMaisCaracteres(){
		Stream teste = new StreamImpl("".toCharArray());
		teste.getNext();
	}
	
	@Test(expected = IllegalStateException.class)
	public void deveLancarIllegalStateExceptionQuandoNullNoStream(){
		new StreamImpl(null);
	}
	
}
