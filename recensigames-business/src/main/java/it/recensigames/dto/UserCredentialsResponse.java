package it.recensigames.dto;

public class UserCredentialsResponse {
	private String username;
	private String password;
	
	public UserCredentialsResponse() {
	}
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
}
