package musifan.musifan.dto;

public class EntityToDto {
	
	public static Album AlbumToAlbumDto(musifan.musifan.entity.Album album) {
		Album albumDto = new Album();
		albumDto.setTitre(album.getTitre());
		albumDto.setId(album.getId());
		albumDto.setPhoto(album.getPhoto());
		albumDto.setChansons());
		
		return null;
	}

}
