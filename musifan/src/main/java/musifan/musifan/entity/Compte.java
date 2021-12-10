package musifan.musifan.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public class Compte implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView({ JsonViews.Common.class, })
	private Long id;

	@Email
	@JsonView({ JsonViews.Common.class, })
	private String mail;

	private String password;

	@JsonView({ JsonViews.Common.class, })
	private String nom;

	@JsonView({ JsonViews.Common.class, })
	private String prenom;

	@Pattern(regexp = "^(0|\\+33 )[1-9]([-. ]?[0-9]{2} ){3}([-. ]?[0-9]{2})$")
	@JsonView({ JsonViews.Common.class, })
	private String telephone;

	private boolean enable;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Lob
	@JsonView({ JsonViews.Common.class, })
	private Byte[] photoProfil;

	@Version
	@Column(name = "compte_version")
	private int version;

	public Compte() {

	}

	public Compte(String mail, String password, String nom, String prenom, String telephone, Byte[] photoProfil) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.photoProfil = photoProfil;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	// Methodes pour l'authentification
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnable();
	}

	public Compte getCompte() {
		return this;
	}
	
}
