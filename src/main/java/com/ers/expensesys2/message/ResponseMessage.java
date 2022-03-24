package com.ers.expensesys2.message;

public class ResponseMessage {

	private String message;
	
	public ResponseMessage(String messages) {
		this.message = messages;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
