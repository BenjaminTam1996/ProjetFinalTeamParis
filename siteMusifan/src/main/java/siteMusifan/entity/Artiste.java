package siteMusifan.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(name="seqCompte", sequenceName = "seq_artiste", initialValue = 100, allocationSize = 1)
public class Artiste extends Compte {
	@Column(name="artiste_nomArtiste")
	private String nomArtiste;
	
	@Column(name="artiste_photoBanniere")
	private Byte[] photoBanniere;
	
	@Column(name="artiste_description")
	private String description;
	
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
	
	
	
}
