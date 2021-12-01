package musifan.musifan.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "ligne_concert")
public class LigneConcert {
		@EmbeddedId
		@JsonView(JsonViews.ArtisteComplet.class)
		private LigneConcertPK id;
		
		public LigneConcert() {
		}
		
		public LigneConcert(LigneConcertPK id) {
			this.id = id;
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
			LigneConcert other = (LigneConcert) obj;
			return Objects.equals(id, other.id);
		}

		public LigneConcertPK getId() {
			return id;
		}

		public void setId(LigneConcertPK id) {
			this.id = id;
		}

		
		


}
