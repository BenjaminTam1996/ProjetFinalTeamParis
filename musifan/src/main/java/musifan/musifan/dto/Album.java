package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import musifan.musifan.entity.LigneAlbum;

public class Album {
	
	private Long id;
	private String titre;
	private Byte photo;
	private Set<Chanson> chansons;
	private Set<Artiste> artistes = new HashSet<Artiste>();
	
	public Album(musifan.musifan.entity.Album album) {
		this.id = album.getId();
		this.titre = album.getTitre();
		this.photo = album.getPhoto();
		this.chansons = album.getChansons();
		
		for(LigneAlbum la : album.getLignesAlbums()) {
			artistes.add(la.getId().getArtiste());
		}
		
	}
	
	
}
