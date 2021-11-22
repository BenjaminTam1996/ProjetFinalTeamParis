package siteMusifan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	List<Album> findByAlbum(String album);

	List<Album> findByAlbumLike(String album);

	List<Album> findByAlbumContaining(String album);

	List<Album> findByAlbumContainingIgnoreCase(String album);


	@Query("select c from Album c left join fetch c.commandes where c.id=:id")
	Optional<Album> findByIdWithCommandes(@Param("id") Long id);

	// @Query("select c from Album c left join fetch c.commandes")
	List<Album> findAllWithCommandes();
}
