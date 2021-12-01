package musifan.musifan.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="publication")
@SequenceGenerator(name ="seqPublication",sequenceName ="seq_publication",allocationSize = 1,initialValue =100)
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqPublication")	
	@Column(name="publication_id")
	@JsonView({JsonViews.Common.class,})
	private Long id;
	
	@Column(name="publication_description")
	@Lob
	@JsonView({JsonViews.Common.class,})
	private String desciption;
	
	@Column(name="publication_image")
	@Lob
	@JsonView({JsonViews.Common.class,})
	private byte[] image;
	
	@Column(name="publication_date")
	@JsonView({JsonViews.Common.class,})
	private LocalDate date = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "publication_artiste_id", foreignKey = @ForeignKey(name = "publication_artiste_id_fk"))
	private Artiste artiste;

	public Publication() {
	}

	public Publication(String desciption, Artiste artiste) {
		super();
		this.desciption = desciption;
		this.artiste = artiste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
		Publication other = (Publication) obj;
		return Objects.equals(id, other.id);
	}
	
}
