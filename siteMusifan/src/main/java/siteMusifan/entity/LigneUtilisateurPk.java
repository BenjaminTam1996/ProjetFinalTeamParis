package siteMusifan.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class LigneUtilisateurPk implements Serializable {
	@ManyToOne
	@JoinColumn(name="ligne_utilisateur_utilisateur_id", foreignKey = @ForeignKey(name="ligne_utilisateur_utilisateur_id_fk"))
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="ligne_utilisateur_artiste_id", foreignKey = @ForeignKey(name="ligne_utilisateur_artiste_id_fk"))
	@JsonView({JsonViews.UtilisateurAvecArtiste.class,})
	private Artiste artiste;
	
	public LigneUtilisateurPk() {
	
	}

	public LigneUtilisateurPk(Utilisateur utilisateur, Artiste artiste) {
		this.utilisateur = utilisateur;
		this.artiste = artiste;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artiste, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneUtilisateurPk other = (LigneUtilisateurPk) obj;
		return Objects.equals(artiste, other.artiste) && Objects.equals(utilisateur, other.utilisateur);
	}
	
	
	
}
