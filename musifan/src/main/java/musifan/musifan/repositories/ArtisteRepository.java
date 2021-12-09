package musifan.musifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Long>{

	//Remonter un artiste avec ses albums
	Optional<Artiste> byKeyWithAlbums(@Param("key") Long key);
	
	//Remonter un artiste avec ses concerts
	Optional<Artiste> byKeyWithConcerts(@Param("key") Long key);

	//Remonter un artiste avec ses publications
	@Transactional
	Optional<Artiste> byKeyWithPublications(@Param("key") Long key);
	
	//Remonter un artiste complet, c'est-a-dire avec ses albums, ses concerts, ses publications et ses utilisateurs
	@Transactional
	@Query("select distinct a from Artiste a left join fetch a.lignesAlbums left join fetch a.ligneConcerts left join fetch a.publications where a.id=:key")
	Optional<Artiste> findByKeyWithArtisteComplet(@Param("key") Long key);

	//Trouver un artiste par son nom
	List<Artiste> findByNomArtisteContainingIgnoreCase(String nom);
	
	List<Artiste> findByNomArtisteIgnoreCase(String nom);
	
	List<Artiste> findByNomArtisteLikeIgnoreCase(String nom);
	
}
