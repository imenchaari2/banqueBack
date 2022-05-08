package tn.enis.service;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.Path;
import tn.enis.dao.ClientDao;
import tn.enis.entity.Client;


@Stateless
@Path("/client")
public class ClientService {

	@EJB
	private ClientDao clientDao;


	public void save(Client client) {
		clientDao.save(client);
	}
	

	public void update(Client client) {
		
		Client nVclient = this.getById(client.getId());
		nVclient.setNom(client.getNom());
		nVclient.setPrenom(client.getPrenom()) ; 
		nVclient.setAddresse(client.getAddresse()) ; 
		
		clientDao.update(nVclient);
	}
	
	
	public void delete(Long id) {
		clientDao.delete(getById(id));
	}
	public Client getById(Long id) {
		return clientDao.getById(id);
	}

	
	public List<JsonObject> getAllClients() {
		return clientDao.getAll();
	}


}