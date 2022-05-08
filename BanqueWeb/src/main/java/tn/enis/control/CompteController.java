package tn.enis.control;

import java.util.List;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tn.enis.entity.Compte;
import tn.enis.service.CompteService;

@Path("/CompteController")
public class CompteController {
	
	@EJB
	private CompteService compteService;
	
	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void save(Compte compte) {
		compteService.save(compte);
	}
	
	@Path("/comptes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<JsonObject> getAllComptes() {
		return compteService.getAllComptes();
	}
	
	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Compte compte) {
		compteService.update(compte) ; 
		
	}
	@Path("/delete/{rib}")
	@DELETE
	public void delete(@PathParam(value="rib") Long rib) {
		compteService.delete(rib);
	}
	
	@GET
	@Path("/find/{rib}")
	@Produces(MediaType.APPLICATION_JSON)

	public JsonObject getByIdJson(@PathParam(value="rib") Long rib) {
		Compte compte = compteService.getById(rib);
		return compte.toJson();
	}
	@Path("/comptesByClients/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<JsonObject> getAllCompteByClient(@PathParam(value="id") Long id) {
		return compteService.getAllCompteByClient(id);
	}

}