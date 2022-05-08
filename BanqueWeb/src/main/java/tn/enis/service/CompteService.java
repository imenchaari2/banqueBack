package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;

import tn.enis.dao.ClientDao;
import tn.enis.dao.CompteDao;
import tn.enis.entity.Client;
import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteService
 */
@Stateless
public class CompteService {

	@EJB
	private CompteDao compteDao;
	
	@EJB
	private ClientDao clientDao;
	
	
	public void save(Compte compte) {
		compteDao.save(compte);
	}
	
	
	public void update(Compte compte) {
		Compte nVcompte = this.getById(compte.getRib());
		nVcompte.setSolde(compte.getSolde());
		compteDao.update(nVcompte);
	}

	public void delete(Long rib) {
		compteDao.delete(getById(rib));
	}
	
	
	public Compte getById( Long rib) {
		return compteDao.getById(rib);
	}
	
	public List<JsonObject> getAllCompteByClient(Long id) {
		Client client = clientDao.getById(id);
		return compteDao.getAllByClient(client);
	}
	

	public List<JsonObject> getAllComptes() {
		return compteDao.getAll();
	}
	
	
	
	
}