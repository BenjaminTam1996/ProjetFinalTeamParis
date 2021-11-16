package siteMusifan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name="artiste_id")),
	@AttributeOverride(name = "mail", column = @Column(name="artiste_mail")),
	@AttributeOverride(name = "password", column = @Column(name = "artiste_password")),
	@AttributeOverride(name = "nom", column = @Column(name = "artiste_nom")),
	@AttributeOverride(name = "prenom", column = @Column(name = "artiste_prenom")),
	@AttributeOverride(name = "telephone", column = @Column(name = "artiste_telephone")),
	@AttributeOverride(name = "photoProfil", column = @Column(name = "artiste_photoProfil")),
})
@Table(name="artiste")
@SequenceGenerator(name="seqCompte", sequenceName = "seq_artiste", initialValue = 100, allocationSize = 1)
public class Artiste extends Compte {
	@Column(name="artiste_nomArtiste")
	private String nomArtiste;
	
	@Column(name="artiste_photoBanniere")
	private Byte[] photoBanniere;
	
	@Column(name="artiste_description")
	private String description;
	
	@OneToMany(mappedBy = "artiste", fetch = FetchType.LAZY)
	private Set<Publication> publications;
	
	@OneToMany(mappedBy = "id.artiste")
	private Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
	
	@OneToMany(mappedBy = "id.artiste")
	private Set<LigneUtilisateur> lignesUtilisateurs = new HashSet<LigneUtilisateur>();
	
	public Artiste() {
		
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public Byte[] getPhotoBanniere() {
		return photoBanniere;
	}

	public void setPhotoBanniere(Byte[] photoBanniere) {
		this.photoBanniere = photoBanniere;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	public Set<LigneAlbum> getLignesAlbums() {
		return lignesAlbums;
	}

	public void setLignesAlbums(Set<LigneAlbum> lignesAlbums) {
		this.lignesAlbums = lignesAlbums;
	}

	public Set<LigneUtilisateur> getLignesUtilisateurs() {
		return lignesUtilisateurs;
	}

	public void setLignesUtilisateurs(Set<LigneUtilisateur> lignesUtilisateurs) {
		this.lignesUtilisateurs = lignesUtilisateurs;
	}
	
	
	
}
