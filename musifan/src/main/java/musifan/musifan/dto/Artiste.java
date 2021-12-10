package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

public class Artiste {
	private Long id;
	private String mail;
	private String password;
	private String nom;
	private String prenom;
	private String telephone;
	private Byte[] photoProfil;
	private Byte[] photoBanniere;
	private String nomArtiste;
	private String description;
	private Set<Album> publications = new HashSet<Album>();
	private Set<Concert> concerts = new HashSet<Concert>();
	
	public Artiste() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(Byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}

	public Byte[] getPhotoBanniere() {
		return photoBanniere;
	}

	public void setPhotoBanniere(Byte[] photoBanniere) {
		this.photoBanniere = photoBanniere;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Album> getPublications() {
		return publications;
	}

	public void setPublications(Set<Album> publications) {
		this.publications = publications;
	}

	public Set<Concert> getConcerts() {
		return concerts;
	}

	public void setConcerts(Set<Concert> concerts) {
		this.concerts = concerts;
	}
	
	
}
