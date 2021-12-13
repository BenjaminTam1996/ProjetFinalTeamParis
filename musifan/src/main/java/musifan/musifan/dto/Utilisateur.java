package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.dto.Commande;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.entity.LigneUtilisateur;

public class Utilisateur {
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
	private Byte[] photoProfil;
	@JsonView({JsonViews.Common.class,})
	private String pseudo;
	@JsonView({JsonViews.UtilisateurAvecCommandes.class,})
	private Set<Commande> commande = new HashSet<Commande>();
	@JsonView({JsonViews.UtilisateurAvecArtiste.class,})
	private Set<Artiste> artistes = new HashSet<Artiste>();
	
	public Utilisateur() {
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}

	public Set<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(Set<Artiste> artistes) {
		this.artistes = artistes;
	}
	
	

}
