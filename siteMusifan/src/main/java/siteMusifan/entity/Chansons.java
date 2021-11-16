package siteMusifan.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chansons")
@SequenceGenerator(name = "seqChansons", sequenceName = "seq_chansons", allocationSize = 1,initialValue = 100)
public class Chansons {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqChansons")
	@Column(name = "chansons_id")
	private Long id;
	@Column(name = "chansons_titre")
	private String titre;
	@Column(name = "chansons_duree")
	private int duree;
	@ManyToOne
	@JoinColumn(name = "chanson_album_id", foreignKey = @ForeignKey(name = "chanson_album_id_fk"))
	private Album album;
	
	
	public Chansons() {

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


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
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
		Chansons other = (Chansons) obj;
		return Objects.equals(id, other.id);
	}

}