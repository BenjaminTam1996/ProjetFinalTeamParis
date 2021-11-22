package siteMusifan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Album;
import siteMusifan.entity.Chansons;



public interface ChansonsRepository extends JpaRepository<Chansons, Long>{
	
	List<Album> findByTitreIgnoreCase(String titre);

	List<Album> findByTitreLikeIgnoreCase(String titre);
	
	@Transactional
	List<Chansons> findByTitreContainingIgnoreCase(String titre);
	
	@Modifying
	@Transactional
	@Query("delete from Chansons c where c.album=:album")
	void deleteByAlbum(@Param("album") Album album);
	
	
}
