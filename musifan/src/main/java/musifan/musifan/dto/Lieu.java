package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.dto.Concert;
import musifan.musifan.entity.JsonViews;

public class Lieu {
	private Long id;
	private String nom;
	private String numRue;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
	private Set<Concert> listeConcerts = new HashSet<Concert>();
	
	
	public static Lieu LieuToLieuDto(musifan.musifan.entity.Lieu lieu) {
		Lieu lieuDto = new Lieu();
		lieuDto.id=lieu.getId();
		lieuDto.nom=(lieu.getNom());
		lieuDto.numRue=lieu.getNumRue();
		lieuDto.rue=lieu.getRue();
		lieuDto.codePostal=lieu.getCodePostal();
		lieuDto.ville=lieu.getVille();
		lieuDto.pays=lieu.getPays();
		
		for (musifan.musifan.entity.Concert c : lieu.getListeConcerts()){
			Concert concertDto = new Concert();
			//concertDto.
		}
		return lieuDto;
	}
}
