package tn.enis.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Client;
import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteDao
 */

@Stateless
public class CompteDao {

	// Point d'accès aux services de JPA
	@PersistenceContext
	private EntityManager em;
	
	
	public void save(Compte compte) {
		em.persist(compte);
	}
	
	public void update(Compte compte) {
		em.merge(compte);
	}

	public void delete(Compte compte) {
		em.remove(compte);
	}
	
	public Compte getById(Long rib) {
		return em.find(Compte.class, rib); // recherche par PK
	}
	
	
	public List<JsonObject> getAll() { // EJB-QL ou JP-QL : orienté Objet
		List<Compte> comptes= em.createQuery("select c from Compte c", Compte.class).getResultList();
		List<JsonObject> comptesString = new ArrayList<>();
		for(Compte c : comptes) {
			comptesString.add(c.toJson()) ; 
			}
		return comptesString;
	}


	
	public List<JsonObject> getAllByClient(Client client) {
		List<Compte> comptes=  em.createQuery("select c from Compte c where c.client=:clt", Compte.class)
				.setParameter("clt", client).getResultList();
		client.setComptes(comptes);
		
		List<JsonObject> comptesString = new ArrayList<>();
		for(Compte c : comptes) {
			comptesString.add(c.toJson()) ; 
			}
		return comptesString;
	}

}