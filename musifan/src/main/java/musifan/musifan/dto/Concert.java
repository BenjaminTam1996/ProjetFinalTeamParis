package musifan.musifan.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;
import musifan.musifan.dto.Lieu;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.LigneConcert;

public class Concert {
	private Long id; 	
	private String nom;	
	private LocalDate date = LocalDate.now();	
	private Lieu lieu;	
	private int nbPlace;	
	private int prix;
	
	private Set<LigneConcert> ligneConcerts = new HashSet<LigneConcert>();
	
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public Set<LigneConcert> getLigneConcerts() {
		return ligneConcerts;
	}
	public void setLigneConcerts(Set<LigneConcert> ligneConcerts) {
		this.ligneConcerts = ligneConcerts;
	}

	
	
}
