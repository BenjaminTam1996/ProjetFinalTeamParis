package musifan.musifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Lieu;
import musifan.musifan.exceptions.LieuException;
import musifan.musifan.repositories.ConcertRepository;
import musifan.musifan.repositories.LieuRepository;

@Service
public class LieuService {
	@Autowired
	private LieuRepository lieuRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private ConcertRepository concertRepository;
	
	
	public void save(Lieu lieu) {
		Set<ConstraintViolation<Lieu>> violations = validator.validate(lieu);
		if(violations.isEmpty()) {
			lieuRepository.save(lieu);
		}else {
			throw new LieuException();
		}	
	}	 
	
	public void delete(Lieu lieu) {
		//lieu = byId(lieu.getId());	//On va cherche le produit en base de donnée
		Lieu lieuEnBase=lieuRepository.findById(lieu.getId()).orElseThrow(LieuException::new);
		concertRepository.removeLieuFromConcertByLieu(lieuEnBase);
		lieuRepository.delete(lieuEnBase);
	}
	
	public List<Lieu> allLieu(){
		return lieuRepository.findAll();
	}
	
	public Lieu byId(Long id) {
		return lieuRepository.findByIdWithConcert(id).orElseThrow(LieuException::new);
	}
	
	public List<Lieu> ByNomIgnoreCase(String nom) {
		return lieuRepository.findByNomIgnoreCase(nom);
	}
	
	public List<Lieu> ByNomLikeIgnoreCase(String nom) {
		return lieuRepository.findByNomIgnoreCase(nom);
	}
	
	public List<Lieu> ByNomContainingIgnoreCase(String nom) {
		return lieuRepository.findByNomIgnoreCase(nom);
	}
	
	public List<Lieu> ByVilleIgnoreCase(String ville) {
		return lieuRepository.findByPaysIgnoreCase(ville);
	}
	
	public List<Lieu> ByVilleLikeIgnoreCase(String ville) {
		return lieuRepository.findByPaysLikeIgnoreCase(ville);
	}
	
	public List<Lieu> ByPaysContainingIgnoreCase(String ville) {
		return lieuRepository.findByPaysContainingIgnoreCase(ville);
	}
	
	public List<Lieu> ByPaysIgnoreCase(String pays) {
		return lieuRepository.findByPaysIgnoreCase(pays);
	}
	
	public List<Lieu> ByPaysLikeIgnoreCase(String pays) {
		return lieuRepository.findByPaysLikeIgnoreCase(pays);
	}
	
	public List<Lieu> ByVilleContainingIgnoreCase(String pays) {
		return lieuRepository.findByPaysContainingIgnoreCase(pays);
	}
}
