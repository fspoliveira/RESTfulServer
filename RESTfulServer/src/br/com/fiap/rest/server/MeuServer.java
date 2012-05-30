package br.com.fiap.rest.server;

import java.io.IOException;
import java.util.Set;

import org.json.JSONException;
import org.restlet.Server;
import org.restlet.data.Form;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonConverter;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import br.com.fiap.bean.Contato;



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
	public void fazPost (Representation rep) throws IOException, JSONException{
		Form form = new Form(rep);
		System.out.println("Executei o POST");
		System.out.println("Names: "+ form.getNames());
		Representation represposta = new StringRepresentation("Sucesso");
		getResponse().setStatus(Status.SUCCESS_ACCEPTED);
		getResponse().setEntity(represposta);
		
		JsonConverter jc = new JsonConverter();
		//Contato c = jc.toObject(rep,Contato.class, null);
		
		//System.out.println(c.getEmail());
		
	}
	


}
