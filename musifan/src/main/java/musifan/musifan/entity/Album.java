package musifan.musifan.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "album")
@NamedQueries({
	@NamedQuery(name="Album.byKeyWithChansons",
			query="select distinct al from Album al left join fetch al.chansons where al.id=:key"),
	@NamedQuery(name="Album.byKeyWithArtistes",
			query="select distinct al from Album al left join fetch al.lignesAlbums where al.id=:key"),
	@NamedQuery(name="Album.byKeyWithChansonsAndArtistes",
	query="select distinct al from Album al left join fetch al.chansons left join fetch al.lignesAlbums where al.id=:key")
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
	@JsonView({JsonViews.AlbumComplet.class,})
	private Set<Chansons> chansons = new HashSet<Chansons>();
	
	@OneToMany(mappedBy = "id.album")
	@JsonView({JsonViews.AlbumAvecArtistes.class,})
	private Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
	
	@Version
	@Column(name="album_version")
	private int version;
	
	public Album() {

	}


	public Album(String titre, LocalDate date) {
		this.titre = titre;
		this.date = date;
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
	

	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public void addChansons(Chansons chansons) {
		this.chansons.add(new Chansons(chansons.getTitre(),chansons.getDuree(),chansons.getAlbum()));
	}
	
	public void addArtiste(Artiste artiste) {
		this.lignesAlbums.add(new LigneAlbum(new LigneAlbumPK(this,artiste)));
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
