package br.com.fiap.rest.server;

import java.util.Set;

import org.restlet.Server;
import org.restlet.data.Form;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;



public class MeuServer extends ServerResource {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new Server(Protocol.HTTP, 8182, MeuServer.class).start();
	}

	@Get
	public String toString() {  
	     return "hello, world"; 
	}
	
	public boolean allowPost(){
		return true;
	}
	
	@Post("json")
	public void fazPost (Representation rep){
		Form form = new Form(rep);
		System.out.println("Executei o POST");
		System.out.println("Names: "+ form.getNames());
		Representation represposta = new StringRepresentation("Sucesso");
		getResponse().setStatus(Status.SUCCESS_ACCEPTED);
		getResponse().setEntity(represposta);
	}
	


}
