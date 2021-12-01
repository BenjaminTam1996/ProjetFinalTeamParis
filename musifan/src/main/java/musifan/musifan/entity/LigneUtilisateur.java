package musifan.musifan.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="ligne_utilisateur")
public class LigneUtilisateur {
	@EmbeddedId
	@JsonView({JsonViews.UtilisateurAvecArtiste.class,})
	private LigneUtilisateurPk id;
	
	public LigneUtilisateur() {
		
	}

	public LigneUtilisateur(LigneUtilisateurPk id) {
		this.id = id;
	}

	public LigneUtilisateurPk getId() {
		return id;
	}

	public void setId(LigneUtilisateurPk id) {
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
		LigneUtilisateur other = (LigneUtilisateur) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
