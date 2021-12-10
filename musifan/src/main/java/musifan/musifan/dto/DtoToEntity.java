package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;
import musifan.musifan.entity.LigneAlbum;
import musifan.musifan.entity.LigneAlbumPK;
import musifan.musifan.entity.LigneConcert;
import musifan.musifan.entity.LigneConcertPK;
import musifan.musifan.entity.Album;
import musifan.musifan.entity.Artiste;

public class DtoToEntity {

	public static musifan.musifan.entity.Album DtoAlbumToEntity(musifan.musifan.dto.Album album) {

		// Conversion d'un album dto en album entity
		Album albumEntity = new Album();
		albumEntity.setTitre(album.getTitre());
		albumEntity.setId(album.getId());
		albumEntity.setPhoto(album.getPhoto());

		for (musifan.musifan.dto.Chanson chansons : album.getChansons()) {
			Chansons chansonEntity = new Chansons();
			chansonEntity.setId(chansons.getId());
			chansonEntity.setTitre(chansons.getTitre());
			chansonEntity.setDuree(chansons.getDuree());
			chansonEntity.setAlbum(albumEntity);
			albumEntity.getChansons().add(chansonEntity);
		}

		Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
		for (musifan.musifan.dto.Artiste a : album.getArtistes()) {
			musifan.musifan.entity.Artiste artisteEntity = new Artiste();
			artisteEntity.setId(a.getId());
			artisteEntity.setMail(a.getMail());
			artisteEntity.setPassword(a.getPassword());
			artisteEntity.setNom(a.getNom());
			artisteEntity.setPrenom(a.getPrenom());
			artisteEntity.setTelephone(a.getTelephone());
			artisteEntity.setPhotoProfil(a.getPhotoProfil());
			artisteEntity.setPhotoBanniere(a.getPhotoBanniere());
			artisteEntity.setNomArtiste(a.getNomArtiste());
			artisteEntity.setDescription(a.getDescription());

			LigneAlbum ligneAlbum = new LigneAlbum(new LigneAlbumPK(albumEntity, artisteEntity));
			lignesAlbums.add(ligneAlbum);
		}

		return albumEntity;
	}


	public static Concert ConcertDtoToConcertEntity(musifan.musifan.dto.Concert concert) {
		// Conversion d'un album entity en album dto
		musifan.musifan.entity.Concert concertEntity = new musifan.musifan.entity.Concert();
		concertEntity.setId(concert.getId());
		concertEntity.setNom(concert.getNom());
		concertEntity.setDate(concert.getDate());
		musifan.musifan.entity.Lieu lieuEntity = new Lieu();
		lieuEntity.setId(concert.getLieu().getId());
		lieuEntity.setNom(concert.getLieu().getNom());
		lieuEntity.setNumRue(concert.getLieu().getNumRue());
		lieuEntity.setRue(concert.getLieu().getRue());
		lieuEntity.setCodePostal(concert.getLieu().getCodePostal());
		lieuEntity.setVille(concert.getLieu().getVille());
		lieuEntity.setPays(concert.getLieu().getPays());
		
		
		concertEntity.setLieu(lieuEntity);
		concertEntity.setNbPlace(concert.getNbPlace());
		concertEntity.setPrix(concert.getPrix());

		
		Set<LigneConcert> lignesConcert = new HashSet<LigneConcert>();
		for (musifan.musifan.dto.Artiste a : concert.getArtistes()) {
			Artiste artisteEntity = new Artiste();
			artisteEntity.setId(a.getId());
			artisteEntity.setMail(a.getMail());
			artisteEntity.setPassword(a.getPassword());
			artisteEntity.setNom(a.getNom());
			artisteEntity.setPrenom(a.getPrenom());
			artisteEntity.setTelephone(a.getTelephone());
			artisteEntity.setPhotoProfil(a.getPhotoProfil());
			artisteEntity.setPhotoBanniere(a.getPhotoBanniere());
			artisteEntity.setNomArtiste(a.getNomArtiste());
			artisteEntity.setDescription(a.getDescription());

			LigneConcert ligneConcert = new LigneConcert(new LigneConcertPK(concertEntity, artisteEntity));
			lignesConcert.add(ligneConcert);
		}

		return concertEntity;
	}

}
