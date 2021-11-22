package siteMusifan.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name="utilisateur_id")),
	@AttributeOverride(name = "mail", column = @Column(name="utilisateur_mail")),
	@AttributeOverride(name = "password", column = @Column(name = "utilisateur_password")),
	@AttributeOverride(name = "nom", column = @Column(name = "utilisateur_nom")),
	@AttributeOverride(name = "prenom", column = @Column(name = "utilisateur_prenom")),
	@AttributeOverride(name = "telephone", column = @Column(name = "utilisateur_telephone")),
	@AttributeOverride(name = "photoProfil", column = @Column(name = "utilisateur_photoProfil")),
})
@NamedQueries({
	@NamedQuery(name="Utilisateur.byKeyWithArtistes",
			query="select u from Utilisateur u left join fetch u.lignesUtilisateurs where u.id=:key"),
	@NamedQuery(name="Utilisateur.byKeyWithCommandes",
			query="select u from Utilisateur u left join fetch u.listeConcert where u.id=:key")
})
@Table(name="utilisateur")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_utilisateur", initialValue = 100, allocationSize = 1)
public class Utilisateur extends Compte{
	@Column(name="utilisateur_pseudo")
	private String pseudo;
	
	@OneToMany
	@Column(name="utilisateur_listeConcert")
	private List<Commande> listeConcert;
	
	@OneToMany(mappedBy = "id.utilisateur")
	private Set<LigneUtilisateur> lignesUtilisateurs = new HashSet<LigneUtilisateur>();

	public Utilisateur() {
		
	}

	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Commande> getListeConcert() {
		return listeConcert;
	}

	public void setListeConcert(List<Commande> listeConcert) {
		this.listeConcert = listeConcert;
	}

	public Set<LigneUtilisateur> getLignesUtilisateurs() {
		return lignesUtilisateurs;
	}

	public void setLignesUtilisateurs(Set<LigneUtilisateur> lignesUtilisateurs) {
		this.lignesUtilisateurs = lignesUtilisateurs;
	}
	
	
	
}
