package com.btc.app.exception;

public class InvalidTypeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidTypeException() {
			
		}
		
		public InvalidTypeException(String message) {
			super(message);
		} 

}
