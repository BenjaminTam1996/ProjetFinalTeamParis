package siteMusifan.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "concert")
@SequenceGenerator(name = "seqConcert", sequenceName = "seq_concert", allocationSize = 1, initialValue = 100)
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConcert")
	@Column(name = "concert_id")
	@JsonView({JsonViews.Common.class,})
	private Long id; 
	@Column(name = "concert_nom")
	@JsonView({JsonViews.Common.class,})
	private String nom;
	@Column(name = "concert_date")
	@JsonView({JsonViews.Common.class,})
	private LocalDate date = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "concert_lieu_id", foreignKey = @ForeignKey(name = "concert_lieu_id_fk"))
	@JsonView({JsonViews.ConcertAvecLieu.class,})
	private Lieu lieu;
	@Column(name = "concert_nbPlace")
	@JsonView({JsonViews.Common.class,})
	private int nbPlace;
	@Column(name = "concert_prix")
	@JsonView({JsonViews.Common.class,})
	private int prix;
	
	@Version
	@Column(name="concert_version")
	private int version;
	
	@OneToMany(mappedBy = "id.concert")
	private Set<LigneCommande> lignesCommandes;

	@OneToMany(mappedBy = "id.concert")
	private Set<LigneConcert> ligneConcerts = new HashSet<LigneConcert>();

	public Concert() {

	}
	
	public Concert(String nom, LocalDate date, Lieu lieu, int nbPlace, int prix) {
		this.nom = nom;
		this.date = date;
		this.lieu = lieu;
		this.nbPlace = nbPlace;
		this.prix = prix;
	}

	public Concert(String nom, LocalDate date, int nbPlace, int prix) {
		this.nom = nom;
		this.date = date;
		this.nbPlace = nbPlace;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(Set<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}

	public Set<LigneConcert> getLigneConcerts() {
		return ligneConcerts;
	}

	public void setLigneConcerts(Set<LigneConcert> ligneConcerts) {
		this.ligneConcerts = ligneConcerts;
	}
	
	//Ajouter un concert a la liste de concert d'un artiste
	public void addArtiste(Artiste artiste) {
		ligneConcerts.add(new LigneConcert(new LigneConcertPK(this, artiste)));
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