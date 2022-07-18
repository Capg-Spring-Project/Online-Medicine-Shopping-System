package com.onlinemedicineshop.security.model;

public class AuthenticationRequest {
	private String username;
	private String password;
	private boolean isAdmin;
	private boolean isUser;

	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String username, String password, boolean isAdmin, boolean isUser) {
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isUser = isUser;
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

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsUser() {
		return isUser;
	}

	public void setIsUser(boolean isUser) {
		this.isUser = isUser;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin
				+ ", isUser=" + isUser + "]";
	}
	
	

}
