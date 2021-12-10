package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.dto.Concert;
import musifan.musifan.entity.JsonViews;

public class Lieu {
	@JsonView({JsonViews.Common.class,})
	private Long id;
	@JsonView({JsonViews.Common.class,})
	private String nom;
	@JsonView({JsonViews.Common.class,})
	private String numRue;
	@JsonView({JsonViews.Common.class,})
	private String rue;
	@JsonView({JsonViews.Common.class,})
	private String codePostal;
	@JsonView({JsonViews.Common.class,})
	private String ville;
	@JsonView({JsonViews.Common.class,})
	private String pays;
	@JsonView(JsonViews.LieuAvecConcert.class)
	private Set<Concert> listeConcerts = new HashSet<Concert>();
	

	public Lieu() {
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


	public String getNumRue() {
		return numRue;
	}


	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Set<Concert> getListeConcerts() {
		return listeConcerts;
	}


	public void setListeConcerts(Set<Concert> listeConcerts) {
		this.listeConcerts = listeConcerts;
	}
	
	
}
