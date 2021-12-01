package musifan.musifan.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Embeddable
public class LigneConcertPK implements Serializable{
		@ManyToOne
		@JoinColumn(name = "ligne_concert_concert_id", foreignKey = @ForeignKey(name = "ligne_concert_concert_id_fk"))
		@JsonView(JsonViews.ArtisteComplet.class)
		private Concert concert;
		@ManyToOne
		@JoinColumn(name = "ligne_concert_artiste_id", foreignKey = @ForeignKey(name = "ligne_concert_artiste_id_fk"))
		private Artiste artiste;

		public LigneConcertPK() {

		}

		public LigneConcertPK(Concert concert, Artiste artiste) {
			this.concert = concert;
			this.artiste = artiste;
		}

		public Concert getConcert() {
			return concert;
		}

		public void setConcert(Concert concert) {
			this.concert = concert;
		}

		public Artiste getArtiste() {
			return artiste;
		}

		public void setArtiste(Artiste artiste) {
			this.artiste = artiste;
		}

		@Override
		public int hashCode() {
			return Objects.hash(artiste, concert);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LigneConcertPK other = (LigneConcertPK) obj;
			return Objects.equals(artiste, other.artiste) && Objects.equals(concert, other.concert);
		}
		
		
}
