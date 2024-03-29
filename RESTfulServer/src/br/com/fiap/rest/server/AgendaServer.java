package br.com.fiap.rest.server;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

import br.com.fiap.rest.AgendaApplication;

/**
 * Classe Principal de um Servidor REST Agenda. 
 * Esta classe implementa um servidor standalone baseado em Restlet.
 */
public class AgendaServer {

	private final static int SERVER_TCP_PORT = 9000;
	
	/**
	 * Metodo principal da aplicacao do Servidor REST de Agenda.
	 * @param args Argumentos de linha de comando
	 * @throws Exception
	 */
	
    public static void main(String[] args) throws Exception {
    	
    	Server server = new Server(Protocol.HTTP, SERVER_TCP_PORT);
    	Component component = new Component();
    	
    	component.getServers().add(server);    	
    	
    	server.getContext().getParameters().add("maxThreads", "512");
    	
        component.getDefaultHost().attach("/agenda",
        		new AgendaApplication());

        component.start();
    }
}