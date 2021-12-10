package musifan.musifan.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "commande")
@NamedQueries({
		@NamedQuery(name = "Commande.byKeyWithConcerts", query = "select distinct c from Commande c left join fetch c.lignesCommandes where c.numero=:numero"),
		@NamedQuery(name = "Commande.allWithConcerts", query = "select distinct c from Commande c left join fetch c.lignesCommandes ") })
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", allocationSize = 1,initialValue = 100)
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_numero")
	private Long numero;
	@Column(name = "commande_date")
	private LocalDate date = LocalDate.now();
	@ManyToOne
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "id.commande")
	private Set<LigneCommande> lignesCommandes = new HashSet<LigneCommande>();

	public Commande() {

	}

	public Commande(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	


	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setClient(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(Set<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Commande other = (Commande) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public void addProduit(Concert concert, int quantite) {
		lignesCommandes.add(new LigneCommande(new LigneCommandePK(this, concert), quantite));
	}
	
	
}
