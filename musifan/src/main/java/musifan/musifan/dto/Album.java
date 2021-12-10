package musifan.musifan.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;

public class Album {
	
	@JsonView(JsonViews.Common.class)
	private Long id;
	@JsonView(JsonViews.Common.class)
	private String titre;
	@JsonView(JsonViews.Common.class)
	private LocalDate date = LocalDate.now();
	@JsonView(JsonViews.Common.class)
	private Byte photo;
	@JsonView({JsonViews.AlbumComplet.class,})
	private Set<Chanson> chansons = new HashSet<Chanson>();
	@JsonView({JsonViews.AlbumAvecArtistes.class,})
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
