package br.com.fiap.rest;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;

public class ServerRESTful extends ServerResource {

	public static void main(String[] args) throws Exception {
		new Server(Protocol.HTTP, 8182, ServerRESTful.class).start();
	}
}