package com.onlinemedicineshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlinemedicineshop.security.model.User;

// Edited
@Entity
public class Admin implements User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Min(1)
	long id;

	private String name;

	@Column(unique = true)
	@NotNull(message = "required")
//	@Pattern(regexp = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")
	String email;

	@NotNull
//	@Size(min = 6, message = "Password must be atleast 6 characters long")
	private String password;

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
