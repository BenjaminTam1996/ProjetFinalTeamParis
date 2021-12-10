package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.LigneAlbum;

public class EntityToDto {
	
	public static Album AlbumToAlbumDto(musifan.musifan.entity.Album album) {
		//Conversion d'un album entity en album dto
		Album albumDto = new Album();
		albumDto.setTitre(album.getTitre());
		albumDto.setId(album.getId());
		albumDto.setPhoto(album.getPhoto());
		
		Set<Chanson> chansonsDto = new HashSet<Chanson>();
		for(Chansons chansons : album.getChansons()) {
			Chanson chansonDto = new Chanson();
			chansonDto.setId(chansons.getId());
			chansonDto.setTitre(chansons.getTitre());
			chansonDto.setDuree(chansons.getDuree());
			chansonDto.setAlbum(albumDto);
			chansonsDto.add(chansonDto);
		}
		albumDto.setChansons(chansonsDto);
		
		for(LigneAlbum la : album.getLignesAlbums()) {
			Artiste artisteDto = new Artiste();
			artisteDto.setId(la.getId().getArtiste().getId());
			artisteDto.setMail(la.getId().getArtiste().getMail());
			artisteDto.setPassword(la.getId().getArtiste().getPassword());
			artisteDto.setNom(la.getId().getArtiste().getNom());
			artisteDto.setPrenom(la.getId().getArtiste().getPrenom());
			artisteDto.setTelephone(la.getId().getArtiste().getTelephone());
			artisteDto.setPhotoProfil(la.getId().getArtiste().getPhotoProfil());
			artisteDto.setPhotoBanniere(la.getId().getArtiste().getPhotoBanniere());
			artisteDto.setNomArtiste(la.getId().getArtiste().getNomArtiste());
			artisteDto.setDescription(la.getId().getArtiste().getDescription());
			albumDto.getArtistes().add(artisteDto);
		}
		
		return albumDto;
	}
	
	public static Lieu LieuToLieuDto(musifan.musifan.entity.Lieu lieu) {
		Lieu lieuDto = new Lieu();
		lieuDto.setId(lieu.getId());
		lieuDto.setNom(lieu.getNom());
		lieuDto.setNumRue(lieu.getNumRue());
		lieuDto.setRue(lieu.getRue());
		lieuDto.setCodePostal(lieu.getCodePostal());
		lieuDto.setVille(lieu.getVille());
		lieuDto.setPays(lieu.getPays());
		
		for (musifan.musifan.entity.Concert c : lieu.getListeConcerts()){
			Concert concertDto = new Concert();
			concertDto.setId(c.getId());
			concertDto.setLieu(lieuDto);
			concertDto.setDate(c.getDate());
			concertDto.setNom(c.getNom());
			concertDto.setNbPlace(c.getNbPlace());
			concertDto.setPrix(c.getPrix());
			lieuDto.getListeConcerts().add(concertDto);
		}
		
		return lieuDto;
	}
	
	public static Concert ConcertToConcertDto(musifan.musifan.entity.Concert concert) {
		//Conversion d'un album entity en album dto
		Concert concertDto = new Concert();
		albumDto.setTitre(album.getTitre());
		albumDto.setId(album.getId());
		albumDto.setPhoto(album.getPhoto());
	}
}
