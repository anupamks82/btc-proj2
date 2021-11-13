package com.btc.app.exception;

public class InvalidRestaurantID  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidRestaurantID() {
			
		}
		
		public InvalidRestaurantID(String message) {
			super(message);
		} 

}
