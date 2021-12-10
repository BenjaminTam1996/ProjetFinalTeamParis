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
			albumDto.setArtistes(la.getId().getArtiste());
		}
		
		return albumDto;
	}

}
