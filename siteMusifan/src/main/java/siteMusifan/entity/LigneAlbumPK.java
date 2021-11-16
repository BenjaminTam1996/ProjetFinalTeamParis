package siteMusifan.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneAlbumPK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "ligne_album_album_id", foreignKey = @ForeignKey(name = "ligne_album_album_id_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "ligne_album_artiste_id", foreignKey = @ForeignKey(name = "ligne_album_artiste_id_fk"))
	private Artiste artiste;

	public LigneAlbumPK() {

	}

	public LigneAlbumPK(Commande commande, Artiste artiste) {
		this.commande = commande;
		this.artiste = artiste;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artiste, commande);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneAlbumPK other = (LigneAlbumPK) obj;
		return Objects.equals(artiste, other.artiste) && Objects.equals(commande, other.commande);
	}

}
