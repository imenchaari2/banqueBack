package tn.enis.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.enis.entity.Client;
import tn.enis.entity.Compte;

@Stateless
public class ClientDao {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public void save(Client client) {
		em.persist(client);
	}

	public void update(Client client) {
		em.merge(client);

	}

	public void delete(Client client) {
		for(Compte c : client.getComptes()) {
			em.remove(c);
		}
		em.remove(client);
	}

	public Client getById(Long id) {
		return em.find(Client.class, id);
	}

	public JsonObject getByIdJson(Long id) {
		Client client = em.find(Client.class, id);
		return client.toJson();
	}

	public List<JsonObject> getAll() {
		List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();
		List<JsonObject> clientsString = new ArrayList<>();
		for (Client c : clients) {
			clientsString.add(c.toJson());
		}
		return clientsString;
	}

}