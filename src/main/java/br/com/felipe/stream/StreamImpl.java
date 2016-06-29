/**
 * 
 */
package br.com.felipe.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.felipe.stream.exception.NaoEncontrouCaracterNaoRepeteException;
import br.com.felipe.stream.exception.StreamEndException;

/**
 * @author Felipe Zanardo Affonso
 *
 */
public class StreamImpl implements Stream {
	
	private char[] stream;
	
	private int posisaoLeitura = -1;
	
	private int ultimaPosicao = 0;
	
	public StreamImpl(final char[] stream) {
		if(stream == null) {
			throw new IllegalStateException();
		}
		this.stream = stream;
		this.ultimaPosicao = this.stream.length - 1;
	}

	/* (non-Javadoc)
	 * @see br.com.felipe.stream.Stream#getNext()
	 */
	@Override
	public char getNext() {
		if(this.hasNext()) {
			this.posisaoLeitura++;
			return stream[this.posisaoLeitura];
		}
		throw new StreamEndException();
	}

	/* (non-Javadoc)
	 * @see br.com.felipe.stream.Stream#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.posisaoLeitura < this.ultimaPosicao;
	}
	
	public static char firstChar(Stream input) {
		Map<Character, Integer> charQtdes = new LinkedHashMap<Character, Integer>();
		while(input.hasNext()) {
			Character key = input.getNext();
			int qtde = 1;
			if(charQtdes.containsKey(key)) {
				qtde = charQtdes.get(key) + 1;
			}
			charQtdes.put(key, qtde);
		}
		Iterator<Character> itChars= charQtdes.keySet().iterator();
		while(itChars.hasNext()) {
			Character charAtual = itChars.next();
			if(charQtdes.get(charAtual).intValue() == 1) {
				return charAtual.charValue();
			}
		}
		throw new NaoEncontrouCaracterNaoRepeteException();
	}

}
