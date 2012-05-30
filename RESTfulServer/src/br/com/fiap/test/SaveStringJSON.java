package br.com.fiap.test;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import br.com.fiap.bean.Contato;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveStringJSON{

	public static void main(String args[]) {

		Contato contato = new Contato();
		contato.setEmail("fspo@email.com");
		contato.setNome("Fernando Santiago");

		// 1. Convert Java object to JSON format
		ObjectMapper mapper = new ObjectMapper();
		try {
			Writer strWriter = new StringWriter();

			mapper.writeValue(strWriter, contato);

			String userDataJSON = strWriter.toString();

			System.out.println(userDataJSON);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
