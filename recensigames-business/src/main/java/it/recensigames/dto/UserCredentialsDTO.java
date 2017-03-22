package it.recensigames.dto;

public class UserCredentialsDTO implements DTO{
	private String username;
	private String password;
	
	public UserCredentialsDTO() {
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
