package com.btc.app.exception;

public class InvalidCategoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCategoryException() {
			
		}
		
		public InvalidCategoryException(String message) {
			super(message);
		} 

}
