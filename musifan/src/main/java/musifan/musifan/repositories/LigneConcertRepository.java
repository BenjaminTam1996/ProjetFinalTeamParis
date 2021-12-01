package musifan.musifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Concert;
import musifan.musifan.entity.LigneConcert;
import musifan.musifan.entity.LigneConcertPK;

public interface LigneConcertRepository extends JpaRepository<LigneConcert, LigneConcertPK>{
	@Transactional
	@Modifying
	@Query("delete from LigneConcert lc where lc.id.artiste =:artiste")
	void deleteByArtiste(@Param("artiste")Artiste artiste);
	
	@Transactional
	@Modifying
	@Query("delete from LigneConcert lc where lc.id.concert =:concert")
	void deleteByConcert(@Param("concert") Concert  concert );
	

}
