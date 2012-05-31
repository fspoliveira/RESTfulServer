package br.com.fiap.rest;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.fiap.bean.Agenda;
import br.com.fiap.bean.Contato;
import br.com.fiap.dao.ContatoDAO;

/**
 * Implementa um "ServerResource" da Agenda (conjunto de Contatos).
 */
public class AgendaResource extends ServerResource {

	/** DAO de persistencia do bean Contato */
	private ContatoDAO contatoDAO = new ContatoDAO();

	/**
	 * Permite o metodo POST.
	 * 
	 * @return true
	 */
	public boolean allowPost() {
		return true;
	}

	/**
	 * Metodo POST: Adiciona um Contato na agenda.
	 * 
	 * @param repContato
	 *            Representacao em JSON do contato
	 * @return Representacao em TEXT_PLAIN.
	 * @throws JSONException
	 */
	@Post("json")
	public Representation inserir(Representation representation)
			throws JSONException {

		Representation result = null;

		try {

			Form form = new Form(representation);

			/* recupera primeira posicao do Array do JSON */
			JSONArray array = new JSONArray(form.getNames().toString());

			/* obtem o objeto Contato a partir do JSON */
			ObjectMapper mapper = new ObjectMapper();
			Contato contato = mapper.readValue(array.get(0).toString(),
					Contato.class);

			/* zera o id, pois vai inserir um novo contato */
			contato.setId(0);

			/* insere o Contato atraves do DAO */
			if (contatoDAO.insert(contato)) {

				setStatus(Status.SUCCESS_CREATED);
				result = new StringRepresentation("Contato Adicionado.",
						MediaType.TEXT_PLAIN);

			} else {
				setStatus(Status.SERVER_ERROR_INTERNAL);
			}

		} catch (IOException e) {

			System.err.println(e.getLocalizedMessage());
			setStatus(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY);
		}

		return result;
	}

	/**
	 * Metodo GET: Lista os Contatos da agenda.
	 * 
	 * @return Representacao em JSON da Agenda de Contatos.
	 */
	@Get("json")
	public Representation listar() {

		/* obtem a lista de contatos */
		List<Contato> contatos = contatoDAO.list();

		if (contatos == null || contatos.size() < 1) {
			return null;
		}

		/* preenche um objeto Agenda com a lista */
		Agenda agenda = new Agenda();
		agenda.setContatos(contatos);

		/* Retorna lista de contatos no formato JSON */
		Representation representation = new JsonRepresentation(agenda);
		representation.setCharacterSet(new CharacterSet("ISO_8859_1"));

		return representation;
	}
}