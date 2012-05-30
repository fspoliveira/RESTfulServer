package br.com.fiap.bean;

import java.util.List;

/**
 * Classe que implementa a Agenda dos contatos. 
 */

public class Agenda {

	private List<Contato> contatos;

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}	

}