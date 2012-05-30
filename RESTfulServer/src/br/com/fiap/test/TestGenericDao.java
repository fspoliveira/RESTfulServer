package br.com.fiap.test;

import br.com.fiap.bean.Contato;

import br.com.fiap.dao.ContatoDAO;

public class TestGenericDao {

	public static void main(String args[]) {

		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = new Contato();		
		
		contato.setEmail("fspoliveira@yahoo.com.br");
		contatoDAO.insert(contato);
		
		System.out.println(contatoDAO.list());

	}

}
