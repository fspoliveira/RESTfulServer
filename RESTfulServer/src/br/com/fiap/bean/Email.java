package br.com.fiap.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Email {

	@Id
	private String email;

	@ManyToOne
	@JoinColumn(name = "idContato")
	private Contato idContato;

	public Email() {
		super();
	}



	public Email(String email, Contato idContato) {
		super();
		this.email = email;
		this.idContato = idContato;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contato getIdContato() {
		return idContato;
	}

	public void setIdContato(Contato idContato) {
		this.idContato = idContato;
	}
	
	

}
