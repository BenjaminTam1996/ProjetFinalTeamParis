package musifan.musifan.dto;

import musifan.musifan.entity.Chansons;

public class Chanson {
	
	private Long id;
	private String titre;
	private String duree;
	private Album album;
	
	public Chanson(Chansons chanson) {
		this.id = chanson.getId();
		this.titre = chanson.getTitre();
		this.duree = chanson.getDuree();
		this.album = new Album(chanson.getAlbum());
	}
	
	

}
