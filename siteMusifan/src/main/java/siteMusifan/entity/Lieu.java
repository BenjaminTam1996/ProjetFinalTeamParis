package siteMusifan.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lieu")
@SequenceGenerator(name ="seqLieu",sequenceName ="seq_lieu",allocationSize = 1,initialValue =100)
public class Lieu {
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqLieu")	
	@Column(name="lieu_id")
	private Long id;
	
	@Column(name="lieu_nom",nullable = false)
	private String nom;
	
	@Column(name="lieu_numero_rue", length = 6)
	private String numRue;
	
	@Column(name="lieu_nom_rue", length = 150)
	private String rue;
	
	@Column(name="lieu_code_postal", length = 10)
	private String codePostal;
	
	@Column(name="lieu_ville", length = 100)
	private String ville;
	
	@Column(name="lieu_pays", length = 100)
	private String pays;
	
	@OneToMany(mappedBy = "lieu", fetch = FetchType.LAZY)
	private Set<Concert> listeConcerts;
	
	//Constructeurs
	public Lieu() {
	}

	//Getter et Setter
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

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Set<Concert> getListeConcerts() {
		return listeConcerts;
	}

	public void setListeConcerts(Set<Concert> listeConcerts) {
		this.listeConcerts = listeConcerts;
	}

	//hashCode & Equals sur l'id
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
		Lieu other = (Lieu) obj;
		return Objects.equals(id, other.id);
	}
	
}
