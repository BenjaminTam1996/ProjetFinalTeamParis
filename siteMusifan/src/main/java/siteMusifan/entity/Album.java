package siteMusifan.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "album")
@NamedQueries({
	@NamedQuery(name="Artiste.findByKeyWithChansons",
			query="select al from Album al left join fetch al.lignesAlbums where al.id=:key"),
})
@SequenceGenerator(name = "seqAlbum", sequenceName = "seq_album", allocationSize = 1,initialValue = 100)
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlbum")
	@Column(name = "album_id")
	@JsonView(JsonViews.Common.class)
	private Long id;
	@Column(name = "album_titre")
	@JsonView(JsonViews.Common.class)
	private String titre;
	@Column(name = "album_date")
	@JsonView(JsonViews.Common.class)
	private LocalDate date = LocalDate.now();
	@Column(name = "album_photo")
	@JsonView(JsonViews.Common.class)
	private Byte photo;
	
	@OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
	private Set<Chansons> chansons;
	
	@OneToMany(mappedBy = "id.album")
	private Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
	
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Byte getPhoto() {
		return photo;
	}


	public void setPhoto(Byte photo) {
		this.photo = photo;
	}


	public Set<Chansons> getChansons() {
		return chansons;
	}


	public void setChansons(Set<Chansons> chansons) {
		this.chansons = chansons;
	}

	

	public Set<LigneAlbum> getLignesAlbums() {
		return lignesAlbums;
	}


	public void setLignesAlbums(Set<LigneAlbum> lignesAlbums) {
		this.lignesAlbums = lignesAlbums;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(id, other.id);
	}

}
