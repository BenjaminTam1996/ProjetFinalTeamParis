package siteMusifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.LigneUtilisateur;
import siteMusifan.entity.LigneUtilisateurPk;
import siteMusifan.entity.Utilisateur;

public interface LigneUtilisateurRepository extends JpaRepository<LigneUtilisateur,	LigneUtilisateurPk>{

	//Supprimer un artiste
	@Transactional
	@Modifying
	@Query("delete from LigneUtilisateur lu where lu.id.artiste = :artiste")
	void deleteByArtiste(@Param("artiste") Artiste artiste);
	
	
	//Supprimer un utilisateur
	@Transactional
	@Modifying
	@Query("delete from LigneUtilisateur lu where lu.id.utilisateur = :utilisateur")
	void deleteByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
	//Retirer un artiste de la liste d'artiste d'un utilisateur et inversement
	@Transactional
	@Modifying
	@Query("delete from LigneUtilisateur lu where lu.id.artiste = :artiste and lu.id.utilisateur = :utilisateur")
	void deleteByArtisteAndUtilisateur(@Param("artiste") Artiste artiste, @Param("utilisateur") Utilisateur utilisateur);
}
