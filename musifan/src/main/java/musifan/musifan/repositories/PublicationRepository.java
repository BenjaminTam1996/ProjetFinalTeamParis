package musifan.musifan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	List<Publication> findByArtiste(Long id);
	
	@Modifying
	@Transactional
	@Query("delete from Publication p where p.artiste=:artiste")
	void deleteByArtiste(@Param("artiste") Artiste artiste);
}
