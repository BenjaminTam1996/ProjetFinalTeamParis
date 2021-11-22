package siteMusifan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	//Remonter un utilisateur avec ses artistes
	Optional<Utilisateur> byKeyWithArtistes(@Param("key") Long key);
	
	//Remonter un utilisateur avec ses commandes
	Optional<Utilisateur> byKeyWithCommandes(@Param("key") Long key);
	
	//Remonter un utilisateur complet, c'est-a-dire avec ses artistes et ses commandes
	@Query("select u from Utilisateur u left join fetch u.lignesUtilisateurs left join fetch u.listeConcert where u.id=:key")
	Optional<Utilisateur> findByKeyWithCommandesAndArtistes(@Param("key") Long key);
}
