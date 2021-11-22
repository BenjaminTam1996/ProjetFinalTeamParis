package siteMusifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Long>{

	//Remonter un artiste avec ses utilisateurs
	Optional<Artiste> byKeyWithUtilisateurs(@Param("key") Long key);

	//Remonter un artiste avec ses albums
	Optional<Artiste> byKeyWithAlbums(@Param("key") Long key);
	
	//Remonter un artiste avec ses concerts
	Optional<Artiste> byKeyWithConcerts(@Param("key") Long key);

	//Remonter un artiste avec ses publications
	Optional<Artiste> byKeyWithPublications(@Param("key") Long key);
	
	//Remonter un artiste complet, c'est-a-dire avec ses albums, ses concerts, ses publications et ses utilisateurs
	@Query("select a from Artiste a left join fetch a.lignesAlbums left join fetch a.lignesConcerts left join a.publications left join fetch a.lignesUtilisateurs where a.id=:key")
	Optional<Artiste> findByKeyWithAlbumsAndConcertsAndPublicationsAndUtilisateurs(@Param("key") Long key);

	//Trouver un artiste par son nom
	List<Artiste> findByNomArtisteContainingIgnoreCase(String nom);
	
}
