package musifan.musifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Album;
import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.LigneAlbum;
import musifan.musifan.entity.LigneAlbumPK;



public interface LigneAlbumRepository extends JpaRepository<LigneAlbum, LigneAlbumPK>{
	@Modifying
	@Transactional
	@Query("delete from LigneAlbum la where la.id.album=:album")
	void deleteByAlbum(@Param("album") Album album);

	@Modifying
	@Transactional
	@Query("delete from LigneAlbum lc where lc.id.artiste=:artiste")
	void deleteByArtiste(@Param("artiste") Artiste artiste);

//	@Modifying
//	@Transactional
//	@Query("delete from LigneAlbum lc where lc.id.chansons=:chansons and lc.id.album=:album")
//	void deleteByAlbumAndChansons(@Param("album") Album album, @Param("chansons") Chansons chansons);
}
