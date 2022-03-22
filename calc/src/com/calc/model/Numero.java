package com.calc.model;

import java.util.Objects;

/**
 * La clase Numero es la súperclase de Entero y Decimal,
 * porque un Numero posee un valor y está escrito
 * en una base (decimal o binario). Los atributos son abstractos
 * para, en sus respectivas clases inicializarlos.
 * 
 * @author Daniel Carpintero
 *
 */
public abstract class Numero {

	protected int valorEntero;
	protected Base base;
	
	
	
	public Numero(int value, Base base) {
		super();
		this.base=base;
		setValorEntero(value);
	}

	
	public Numero(int valor) {
		this(valor, Base.DECIMAL);
	}
	
	/**
	 * Método abstracto que selecciona la parte entera del número
	 * aportado, aunque sea decimal. Sus clases hijas Decimal y
	 * Entero poseen este método.
	 * 
	 * @param valorEntero
	 */
	protected abstract void setValorEntero(int valorEntero);


	public int getValorEntero() {
		return valorEntero;
	}


	public Base getBase() {
		return base;
	}


	@Override
	public int hashCode() {
		return Objects.hash(base, valorEntero);
	}


	@Override
	public boolean equals(Object obj) {
		return this==obj ||
				obj!=null && getClass() != obj.getClass()
				&& ((Numero) obj).base.equals(this.base)
				&& ((Numero) obj).valorEntero==this.valorEntero;
	}


	@Override
	public String toString() {
		return "Numero de tipo "+ getClass().getSimpleName()
				+ " con valorEntero=" + valorEntero 
				+ ", base=" + base;
	}
	
	
	
}
