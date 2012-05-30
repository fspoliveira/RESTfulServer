package br.com.fiap.test;

import br.com.fiap.bean.Contato;
import br.com.fiap.bean.Email;
import br.com.fiap.bean.Logradouro;
import br.com.fiap.bean.Telefone;
import br.com.fiap.dao.ContatoDAO;

public class TestGenericDao {

	public static void main(String args[]) {

		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = new Contato();
		Email email = new Email("fspoliveira@yahoo.com.br");
		Logradouro logradouro = new Logradouro("Rua dos Perdidos, 10","São Paulo", "SP","Brasil");
		Telefone telefone = new Telefone("7070 7070");
		
		contato.setEmail("fspoliveira@yahoo.com.br");

		//contato.setEmail(email);
		//contato.setLogradouro(logradouro);
	//	contato.setTelefone(telefone);

		contatoDAO.insert(contato);
		
		System.out.println(contatoDAO.list());

	}

}
