package musifan.musifan.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Embeddable
public class LigneCommandePK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "ligne_commande_commande_id", foreignKey = @ForeignKey(name = "ligne_commande_commande_id_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "ligne_commande_concert_id", foreignKey = @ForeignKey(name = "ligne_concert_produit_id_fk"))
	@JsonView({JsonViews.UtilisateurAvecCommandes.class,})
	private Concert concert;

	public LigneCommandePK() {

	}

	public LigneCommandePK(Commande commande, Concert concert) {
		this.commande = commande;
		this.concert = concert;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Concert getProduit() {
		return concert;
	}

	public void setProduit(Concert concert) {
		this.concert = concert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((concert == null) ? 0 : concert.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommandePK other = (LigneCommandePK) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (concert == null) {
			if (other.concert != null)
				return false;
		} else if (!concert.equals(other.concert))
			return false;
		return true;
	}
}