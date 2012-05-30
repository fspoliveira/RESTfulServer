package br.com.fiap.bean;

/**
 * Classe que implementa o Telefone
 */

public class Telefone {
	
	private String telefone;
	
	public Telefone() {
		super();
	}

	public Telefone(String telefone) {
		super();
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}