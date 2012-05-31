package br.com.fiap.rest;

import org.restlet.data.CharacterSet;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import br.com.fiap.bean.Contato;
import br.com.fiap.dao.ContatoDAO;

/**
 * Implementa um "ServerResource" de um Contato.  
 */
public class ContatoResource extends ServerResource {

	/** Objeto Contato localizado pela URL */
    private Contato contato = null;
	/** DAO de persistencia do bean Contato */
    private ContatoDAO contatoDAO = new ContatoDAO();

    /**
     * Inicializacao do Resource.
     */
    
    @Override
    protected void doInit() throws ResourceException {

    	/* obtem o id do contato */
    	String strContato = (String) getRequest().getAttributes().get("idContato");
    	int idContato = (strContato != null) ? Integer.valueOf(strContato) : 0;
    	/* localiza o objeto Contato atraves do DAO */
    	this.contato = contatoDAO.find(idContato);
        setExisting(this.contato != null);
    }

    /**
     * Permite o metodo DELETE.
     * @return true
     */
    public boolean allowDelete() {
    	return true;
    }
    
	/**
	 * Metodo DELETE: Remove um Contato da agenda.
	 */
    @Delete
    public void excluir() {

    	if (contato != null) {
        	/* exclui o Contato, atraves do DAO */
            if (contatoDAO.delete(contato.getId())) {
                setStatus(Status.SUCCESS_NO_CONTENT);
                
            } else {
                setStatus(Status.SERVER_ERROR_INTERNAL);
            }
            
        } else {
        	setStatus(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

	/**
	 * Metodo GET: Consulta um contato da agenda.
	 * @return Representacao em JSON do Contato.
	 */
    
    @Get("json")
    public Representation consultar() {
    	
    	/* Transforma o objeto contato em JSON */    	
    	Representation representation = new JsonRepresentation(contato);
		
    	/* Tratamento para acentos */
		representation.setCharacterSet(new CharacterSet("ISO_8859_1"));
    	
		return representation;
    }
}