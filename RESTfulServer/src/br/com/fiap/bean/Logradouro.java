package br.com.fiap.bean;

/**
 * Classe que implementa o Logradouro
 */

public class Logradouro {
	
	private String endereco;
	private String cidade;
	private String estado;
	private String pais;
		
	public Logradouro() {
		super();
	}
		
	public Logradouro(String endereco, String cidade, String estado, String pais) {
		super();
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}