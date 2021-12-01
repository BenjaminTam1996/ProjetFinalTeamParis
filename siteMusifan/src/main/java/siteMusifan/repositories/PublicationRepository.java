package siteMusifan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	Optional<Publication> findByArtiste(Long id);
	
}
