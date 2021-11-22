package siteMusifan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import siteMusifan.entity.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, Long>{
	
	
	List<Lieu> findByNomIgnoreCase(String nom);		//Recherche par nom
	
	 
	List<Lieu> findByNomLikeIgnoreCase(String nom);		//Recherche avec % ou _ pour chercher selon début de mot
	
	
	List<Lieu> findByNomContainingIgnoreCase(String nom);		//Recherche contenant "lettre recherchées"
	
	
	List<Lieu> findByVilleIgnoreCase(String ville);		//Recherche par ville
	
	
	List<Lieu> findByVilleLikeIgnoreCase(String ville);		//Recherche avec % ou _ pour chercher selon début de mot ville
	
	
	List<Lieu> findByVilleContainingIgnoreCase(String ville);		//Recherche contenant "lettre recherchées" ville
	
	
	List<Lieu> findByPaysIgnoreCase(String pays);		//Recherche par pays
	
	
	List<Lieu> findByPaysLikeIgnoreCase(String pays);			//Recherche avec % ou _ pour chercher selon début de mot pays
	
	
	List<Lieu> findByPaysContainingIgnoreCase(String pays);		//Recherche contenant "lettre recherchées" pays
	
}
