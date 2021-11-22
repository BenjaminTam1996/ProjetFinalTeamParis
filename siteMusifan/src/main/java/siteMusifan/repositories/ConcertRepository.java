package siteMusifan.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import siteMusifan.entity.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
	
	
	List<Concert> findByNomIgnoreCase(String nom);		//Recherche par nom
	
	
	List<Concert> findByNomLikeIgnoreCase(String nom);		//Recherche avec % ou _ pour chercher selon début de mot 
	
	
	List<Concert> findByNomContainingIgnoreCase(String nom);		//Recherche contenant "lettre recherchées"
	
	
	List<Concert> findByDate(LocalDate date);		//Recherche par date
	

}
