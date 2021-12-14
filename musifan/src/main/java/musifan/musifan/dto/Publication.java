package musifan.musifan.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;

public class Publication {
	@JsonView({JsonViews.Common.class,})
	private Long id;
	@JsonView({JsonViews.Common.class,})
	private String desciption;
	@JsonView({JsonViews.Common.class,})
	private byte[] image;
	@JsonView({JsonViews.Common.class,})
	private LocalDate date = LocalDate.now();
	
	private Artiste artiste;
	
	public Publication() {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	
	
}
