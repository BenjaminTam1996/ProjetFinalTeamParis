package siteMusifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	List<Publication> findByArtiste(Long id);
	
}
