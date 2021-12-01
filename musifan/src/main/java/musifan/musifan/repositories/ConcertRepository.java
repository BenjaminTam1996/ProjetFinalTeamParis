package musifan.musifan.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
	
	
	List<Concert> findByNomIgnoreCase(String nom);		//Recherche par nom
	
	
	List<Concert> findByNomLikeIgnoreCase(String nom);		//Recherche avec % ou _ pour chercher selon début de mot 
	
	
	List<Concert> findByNomContainingIgnoreCase(String nom);		//Recherche contenant "lettre recherchées"
	
	
	List<Concert> findByDate(LocalDate date);		//Recherche par date
	
	List<Concert> findByLieu(Lieu lieu);
	
	Optional<Concert> byKeyWithArtiste(@Param("key") Long key);
	
	@Transactional
	@Modifying
	@Query("update Concert c set c.lieu=null where c.lieu=:lieu")
	void removeLieuFromConcertByLieu(@Param("lieu") Lieu lieu);
}
