package com.onlinemedicineshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlinemedicineshop.security.model.User;

// Edited
@Entity
public class Admin implements User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotNull(message = "Please enter a name")
	private String name;

	@Column(unique = true)
	@NotNull(message = "Please enter an email")
	@Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$", message = "Please enter a valid email")
	private String email;

	@NotNull
	@Size(min = 6, message = "Password must be atleast 6 characters long")
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
