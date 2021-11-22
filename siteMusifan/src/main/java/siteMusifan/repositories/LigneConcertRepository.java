package siteMusifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.Concert;
import siteMusifan.entity.LigneConcert;

public interface LigneConcertRepository extends JpaRepository<LigneConcert, Long>{
	@Transactional
	@Modifying
	@Query("delete from LigneConcert lc where lc.id.artiste =:artiste")
	void deleteByArtiste(@Param("artiste")Artiste artiste);
	
	@Transactional
	@Modifying
	@Query("delete from LigneConcert lc where lc.id.concert =:concert ")
	void deleteByConcert(@Param("concert ") Concert  concert );
	

}
