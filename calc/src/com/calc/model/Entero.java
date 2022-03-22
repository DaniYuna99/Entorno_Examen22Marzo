package com.calc.model;

public class Entero extends Numero {
	
	private static final int VALOR_MINIMO = -100000;
	private static final int VALOR_MAXIMO = 100001;

	
	
	public Entero(int value, Base base) {
		super(value, base);
	}
	
	public Entero(int value) {
		super(value);
	}

	/**
	 * Setter del atributo "valorEntero" de la súperclase Numero del 
	 * cual hereda Entero. Detecta si dentro de un número hay caracteres
	 * indeseados como letras, o detecta si en un número binario hay números 
	 * que sean otros diferentes de 0s y 1s. También revisa si no rebasa el 
	 * límite máximo o mínimo impuestos en forma de atributos constantes más arriba.
	 */
	@Override
	protected void setValorEntero(int valorEntero) {
		
		String aCadena = letrasEnNumero(valorEntero);
		
		esNumeroBinario(aCadena);
		
		rebasaLimite(valorEntero);
		
		this.valorEntero=valorEntero;
		
	}

	/** 
	 * Método extraído. Detecta si el número está dentro de los límites acordados.
	 * 
	 * @param valorEntero
	 */
	public void rebasaLimite(int valorEntero) {
		if(valorEntero > VALOR_MAXIMO) {
			throw new NumeroException("El valor introducido es mayor de lo permitido");
		}else if(valorEntero < VALOR_MINIMO) {
			throw new NumeroException("El valor introducido es menor de lo permitido");
		}
	}

	/** 
	 * Método extraído. Detecta si un número binario está sólo compuesto por 1s y 0s.
	 * 
	 * @param aCadena
	 */
	public void esNumeroBinario(String aCadena) {
		if(Base.BINARIO.equals(this.base)) {
			for (int i=0; i<aCadena.length(); i++ ) {
				if(i!='1' && i!='0') {
					throw new NumeroException("Un número binario solo contiene 0s y 1s");
				}
			}			
		}
	}

	/**
	 * Método extraído. Detecta si un número contiene caracteres.
	 * 
	 * @param valorEntero
	 * @return
	 */
	public String letrasEnNumero(int valorEntero) {
		String aCadena = String.valueOf(valorEntero);
		for (int i=0; i<aCadena.length(); i++ ) {
			if(Character.isLetter(i)) {
				throw new NumeroException("Un número decimal|binario no contiene letras");
			}
		}
		return aCadena;
	}

}
