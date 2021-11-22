package siteMusifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import siteMusifan.entity.Album;
import siteMusifan.entity.Chansons;
import siteMusifan.entity.LigneAlbum;
import siteMusifan.entity.LigneAlbumPK;



public interface LigneAlbumRepository extends JpaRepository<LigneAlbum, LigneAlbumPK>{
	@Modifying
	@Transactional
	@Query("delete from LigneAlbum la where la.id.album=:album")
	void deleteByAlbum(@Param("album") Album album);

//	@Modifying
//	@Transactional
//	@Query("delete from LigneAlbum lc where lc.id.chansons=:chansons")
//	void deleteByAlbum(@Param("chansons") Chansons chansons);

//	@Modifying
//	@Transactional
//	@Query("delete from LigneAlbum lc where lc.id.chansons=:chansons and lc.id.album=:album")
//	void deleteByAlbumAndChansons(@Param("album") Album album, @Param("chansons") Chansons chansons);
}
