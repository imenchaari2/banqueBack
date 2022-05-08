package tn.enis.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "t_compte")
public class Compte implements Serializable /* spec JEE */ {
	private static final long serialVersionUID = 1L;
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incement
	private Long rib;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;
	private float solde;


	public Compte() { // spec JEE
		super();
	}

	public Compte(Client client, float solde) {
		super();
		this.client = client;
		this.solde = solde;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rib);
	}
	public JsonObject toJson() {
		return Json.createObjectBuilder().add("rib", this.rib)
				.add("solde",this.solde)
				.add("client",client.toJson())
				.build();
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
		Compte other = (Compte) obj;
		return Objects.equals(rib, other.rib);
	}

	@Override
	public String toString() {
		return "Compte [rib=" + rib + ", client=" + client +", solde=" + solde + "]";
	}

}