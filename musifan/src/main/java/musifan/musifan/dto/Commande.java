package musifan.musifan.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.Utilisateur;

public class Commande {
	@JsonView({JsonViews.Common.class,})
	private Long numero;
	@JsonView({JsonViews.Common.class,})
	private LocalDate date = LocalDate.now();
	
	private Utilisateur utilisateur;
	@JsonView({JsonViews.UtilisateurAvecCommandes.class,})
	private Concert concert ;
	@JsonView({JsonViews.Common.class,})
	private int quantite;
	public Commande() {
		super();
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
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Concert getConcert() {
		return concert;
	}
	public void setConcert (Concert concert) {
		this.concert = concert;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
