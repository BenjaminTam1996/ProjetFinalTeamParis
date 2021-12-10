package musifan.musifan.dto;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.JsonViews;

public class Chanson {
	@JsonView({JsonViews.Common.class,})
	private Long id;
	@JsonView({JsonViews.Common.class,})
	private String titre;
	@JsonView({JsonViews.Common.class,})
	private String duree;

	private Album album;
	
	public Chanson() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	

}
