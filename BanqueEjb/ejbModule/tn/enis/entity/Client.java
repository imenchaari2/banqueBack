package tn.enis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/*import javax.json.bind.spi.JsonProvider;*/

@Entity
@Table(name = "t_client")
public class Client implements Serializable /* spec JEE */ {
	private static final long serialVersionUID = 1L;
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nom_client")
	private String nom;
	private String prenom;
	private String addresse;
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes;
	@Transient
	private Compte compte ; 
	
	public Client() { // spec JEE
		super();
	}

	public Client(String nom,String prenom,String addresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	public JsonObject toJson() {
		return Json.createObjectBuilder().add("id", this.id)
				.add("nom",this.nom)
				.add("prenom",this.prenom)
				.add("addresse", this.addresse)
				.build();
		
		

	}

}