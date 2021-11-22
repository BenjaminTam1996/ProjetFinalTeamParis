package siteMusifan.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "ligne_album")
public class LigneAlbum {
	@EmbeddedId
	private LigneAlbumPK id;
	
	public LigneAlbum() {
	}
	
	public LigneAlbum(LigneAlbumPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	
	public LigneAlbumPK getId() {
		return id;
	}

	public void setId(LigneAlbumPK id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneAlbum other = (LigneAlbum) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	

}

