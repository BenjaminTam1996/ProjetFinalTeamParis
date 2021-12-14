package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;

public class Artiste {
	@JsonView({JsonViews.Common.class,})
	private Long id;
	@JsonView({JsonViews.Common.class,})
	private String mail;
	private String password;
	@JsonView({JsonViews.Common.class,})
	private String nom;
	@JsonView({JsonViews.Common.class,})
	private String prenom;
	@JsonView({JsonViews.Common.class,})
	private String telephone;
	@JsonView({JsonViews.Common.class,})
	private byte[] photoProfil;
	@JsonView({JsonViews.Common.class,})
	private byte[] photoBanniere;
	@JsonView({JsonViews.Common.class,})
	private String nomArtiste;
	@JsonView({JsonViews.Common.class,})
	private String description;
	@JsonView({JsonViews.ArtisteComplet.class, JsonViews.UtilisateurAvecAlbumsArtiste.class})
	private Set<Album> albums = new HashSet<Album>();
	@JsonView({JsonViews.ArtisteComplet.class,})
	private Set<Concert> concerts = new HashSet<Concert>();
	@JsonView({JsonViews.ArtisteComplet.class,JsonViews.UtilisateurAvecPublicationsArtiste.class})
	private Set<Publication> publications = new HashSet<Publication>();
	
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

	public byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}

	public byte[] getPhotoBanniere() {
		return photoBanniere;
	}

	public void setPhotoBanniere(byte[] photoBanniere) {
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

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Concert> getConcerts() {
		return concerts;
	}

	public void setConcerts(Set<Concert> concerts) {
		this.concerts = concerts;
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}
	
	
	
	
}
