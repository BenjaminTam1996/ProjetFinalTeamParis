package siteMusifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import siteMusifan.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
}
