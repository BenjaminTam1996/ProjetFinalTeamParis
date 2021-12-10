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
import musifan.musifan.entity.Lieu;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.LigneConcert;

public class Concert {
	private Long id; 	
	private String nom;	
	private LocalDate date = LocalDate.now();	
	private Lieu lieu;	
	private int nbPlace;	
	private int prix;
	
	private Set<LigneCommande> lignesCommandes;
	private Set<LigneConcert> ligneConcerts = new HashSet<LigneConcert>();

	
	
}
