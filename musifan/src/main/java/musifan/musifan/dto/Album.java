package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import musifan.musifan.entity.LigneAlbum;

public class Album {
	
	private Long id;
	private String titre;
	private Byte photo;
	private Set<Chanson> chansons = new HashSet<Chanson>();
	private Set<Artiste> artistes = new HashSet<Artiste>();
	
	public Album() {
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

	public Byte getPhoto() {
		return photo;
	}

	public void setPhoto(Byte photo) {
		this.photo = photo;
	}

	public Set<Chanson> getChansons() {
		return chansons;
	}

	public void setChansons(Set<Chanson> chansons) {
		this.chansons = chansons;
	}

	public Set<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(Set<Artiste> artistes) {
		this.artistes = artistes;
	}
	
	
	
	
}
