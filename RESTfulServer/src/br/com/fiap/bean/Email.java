package br.com.fiap.bean;

/**
 * Classe que implementa o Email
 */

public class Email {
	
	private String email;
	
	public Email() {
		super();
	}

	public Email(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}