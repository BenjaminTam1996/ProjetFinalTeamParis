package musifan.musifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import musifan.musifan.entity.Lieu;

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
	
	@Query("select l from Lieu l left join fetch l.listeConcerts where l.id =:id")
	Optional<Lieu> findByIdWithConcert(@Param("id") Long Id);
	
}
