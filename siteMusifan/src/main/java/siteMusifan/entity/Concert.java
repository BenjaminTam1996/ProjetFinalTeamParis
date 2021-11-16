package siteMusifan.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "concert")
@SequenceGenerator(name = "seqConcert", sequenceName = "seq_concert", allocationSize = 1)
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConcert")
	@Column(name = "concert_id")
	private Long id;
	@Column(name = "concert_date")
	private LocalDate date = LocalDate.now();
	@Column(name = "concert_lieu")
	private Lieu lieu;
	@Column(name = "concert_nbPlace")
	private int nbPlace;
	@Column(name = "concert_prix")
	private int prix;
	@OneToMany(mappedBy = "id.concert")
	private Set<LigneCommande> lignesCommandes;
	
	
	public Concert() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Set<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}


	public void setLignesCommandes(Set<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(id, other.id);
	}


	

}