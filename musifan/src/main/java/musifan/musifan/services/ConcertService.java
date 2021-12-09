package musifan.musifan.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;
import musifan.musifan.exceptions.ArtisteException;
import musifan.musifan.exceptions.ConcertException;
import musifan.musifan.repositories.ConcertRepository;
import musifan.musifan.repositories.LieuRepository;
import musifan.musifan.repositories.LigneConcertRepository;

@Service 
public class ConcertService {
	@Autowired
	private ConcertRepository concertRepository; 
	
	@Autowired
	private LigneConcertRepository ligneconcertRepository;
	
	@Autowired
	private LieuRepository lieuRepository;
	
	@Autowired
	private Validator validator;
	
	public void create(Concert concert) {
		Set<ConstraintViolation<Concert>> violations = validator.validate(concert);
		if(violations.isEmpty()) {
			concertRepository.save(concert);
			concert.getLieu().getListeConcerts().add(concert);
			ligneconcertRepository.saveAll(concert.getLigneConcerts());

		}else {
			throw new ConcertException();
		}	
	}	
	
	public void update(Concert concert) {
		Set<ConstraintViolation<Concert>> violations = validator.validate(concert);
		if(violations.isEmpty()) {
			concert.getLieu().getListeConcerts().add(concert);
			ligneconcertRepository.saveAll(concert.getLigneConcerts());
			concertRepository.save(concert);

		}else {
			throw new ConcertException();
		}	
	}	
	
	public void delete(Concert concert) {
		Concert concertEnBase=concertRepository.findById(concert.getId()).orElseThrow(ConcertException::new);
		ligneconcertRepository.deleteByConcert(concertEnBase); 
		concertRepository.delete(concertEnBase); 
	}
	
	public List<Concert> allConcert(){
		return concertRepository.findAll();
	}
	
	public List<Concert> allByDate(LocalDate date){
		return concertRepository.findByDate(date);
	}
	
	public List<Concert> allByLieu(Lieu lieu){
		return concertRepository.findByLieu(lieu);
	}
	
	public Concert byId(Long id) {
		return concertRepository.findById(id).orElseThrow(ConcertException::new);
	}
	
	public Concert byKeyWithArtiste(Long id) {
		return concertRepository.byKeyWithArtistes(id).orElseThrow(ArtisteException::new);
	}
	
	public List<Concert> ByNomIgnoreCase(String nom) {
		return concertRepository.findByNomIgnoreCase(nom);
	}
	
	public List<Concert> ByNomLikeIgnoreCase(String nom) {
		return concertRepository.findByNomIgnoreCase(nom);
	}
	
	public List<Concert> ByNomContainingIgnoreCase(String nom) {
		return concertRepository.findByNomIgnoreCase(nom);
	}
}
