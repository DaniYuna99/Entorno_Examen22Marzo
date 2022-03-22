package com.calc.model;

/**
 * Lanza unos mensajes si ocurren determinadas Exceptions.
 * 
 * @author estudiante
 *
 */
@SuppressWarnings("serial")
public class NumeroException extends RuntimeException {

	public NumeroException() {
	}

	public NumeroException(String message) {
		super(message);
	}

	public NumeroException(Throwable cause) {
		super(cause);
	}


}
