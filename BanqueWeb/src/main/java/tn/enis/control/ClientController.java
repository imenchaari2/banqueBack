package tn.enis.control;



import java.util.List;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tn.enis.entity.Client;
import tn.enis.service.ClientService;
import tn.enis.service.CompteService;

/**
 * Servlet implementation class CompteController
 */


@Path("/ClientController")
public class ClientController  {
	@EJB
	private ClientService clientService;
	@EJB
	private CompteService compteService;
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void save(Client client) {
		clientService.save(client);
	}
	@GET
	@Path("/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JsonObject> getAllClients() {
		return clientService.getAllClients();
	}
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public JsonObject getByIdJson(@PathParam(value="id") Long id) {
		Client client1 = clientService.getById(id);
		System.out.println(client1);
		return client1.toJson();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Client client) {
		clientService.update(client) ; 
		
	}
	
	@Path("/delete/{id}")
	@DELETE
	public void delete(@PathParam(value="id") Long id) {
		clientService.delete(id);
	}


}