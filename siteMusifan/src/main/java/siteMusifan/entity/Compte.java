package siteMusifan.entity;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView({JsonViews.Common.class,})
	private Long id;
	
	@Email
	@JsonView({JsonViews.Common.class,})
	private String mail;
	
	@JsonView({JsonViews.Common.class,})
	private String password;
	
	@JsonView({JsonViews.Common.class,})
	private String nom;
	
	@JsonView({JsonViews.Common.class,})
	private String prenom;
	
	@Pattern(regexp = "^(0|\\+33 )[1-9]([-. ]?[0-9]{2} ){3}([-. ]?[0-9]{2})$")
	@JsonView({JsonViews.Common.class,})
	private String telephone;
	
	@JsonView({JsonViews.Common.class,})
	private Byte[] photoProfil;
	
	//////////////////////////////
	@Version
	private int version;
	//////////////////////////////
	
	public Compte() {
		
	}

	public Compte(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
