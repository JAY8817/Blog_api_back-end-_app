package com.example.demo.payload;

public class Apiresponce {

	
	String message;
	boolean status;
	
	public Apiresponce(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public Apiresponce() {
		super();
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
