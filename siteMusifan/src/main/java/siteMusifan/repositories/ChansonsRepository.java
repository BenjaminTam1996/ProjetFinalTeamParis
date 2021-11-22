package siteMusifan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Album;
import siteMusifan.entity.Chansons;



public interface ChansonsRepository extends JpaRepository<Chansons, Long>{
	
	List<Album> findByTitreIgnoreCase(String titre);

	List<Album> findByTitreLikeIgnoreCase(String titre);
	
	@Transactional
	List<Chansons> findByTitreContainingIgnoreCase(String titre);
	
	
}
