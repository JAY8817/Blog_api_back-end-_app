package com.example.demo.payload;


import lombok.Data;

@Data
public class JwtAuthResponse {

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private String token;

	
	public JwtAuthResponse(String token) {
		super();
		this.token = token;
	}

	
	public JwtAuthResponse() {
		super();
	}
	
	
}
