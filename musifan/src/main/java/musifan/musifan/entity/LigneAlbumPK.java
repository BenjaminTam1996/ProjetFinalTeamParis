package musifan.musifan.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class LigneAlbumPK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "ligne_album_album_id", foreignKey = @ForeignKey(name = "ligne_album_album_id_fk"))
	@JsonView(JsonViews.ArtisteComplet.class)
	private Album album;
	@ManyToOne
	@JoinColumn(name = "ligne_album_artiste_id", foreignKey = @ForeignKey(name = "ligne_album_artiste_id_fk"))
	private Artiste artiste;

	public LigneAlbumPK() {

	}

	public LigneAlbumPK(Album album, Artiste artiste) {
		this.album = album;
		this.artiste = artiste;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artiste, album);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneAlbumPK other = (LigneAlbumPK) obj;
		return Objects.equals(artiste, other.artiste) && Objects.equals(album, other.album);
	}

}
