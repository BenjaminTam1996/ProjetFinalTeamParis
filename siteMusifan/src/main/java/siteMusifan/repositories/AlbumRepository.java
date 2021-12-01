package siteMusifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Album;
import siteMusifan.entity.Lieu;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	List<Album> findByTitreIgnoreCase(String titre);

	List<Album> findByTitreLikeIgnoreCase(String titre);  

	List<Album> findByTitreContainingIgnoreCase(String titre);

	Optional<Album> byKeyWithChansons(@Param("key") Long key);

	Optional<Album> byKeyWithArtistes(@Param("key") Long key);
	
	Optional<Album> byKeyWithChansonsAndArtistes(@Param("key") Long key);
}
