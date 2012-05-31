package br.com.fiap.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Classe que implementa a aplicacao REST da Agenda. 
 */
public class AgendaApplication extends Application {

	/**
	 * Cria um "router" e mapeia as URL's permitidas.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {

		Router router = new Router(getContext());

		router.attachDefault(AgendaResource.class);

		router.attach("/contatos", AgendaResource.class);
		router.attach("/contatos/{idContato}", ContatoResource.class);

		return router;
	}
}