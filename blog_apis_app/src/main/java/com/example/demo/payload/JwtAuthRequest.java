package com.example.demo.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;

	private String password;

	public JwtAuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public JwtAuthRequest() {
		super();
	}

}
