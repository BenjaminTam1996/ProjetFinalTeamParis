package siteMusifan.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
import siteMusifan.exceptions.ConcertException;
import siteMusifan.exceptions.LieuException;
import siteMusifan.repositories.ConcertRepository;
import siteMusifan.repositories.LigneConcertRepository;

@Service
public class ConcertService {
	@Autowired
	private ConcertRepository concertRepository;
	
	@Autowired
	private LigneConcertRepository ligneconcertRepository;
	
	@Autowired
	private Validator validator;
	
	public void save(Concert concert) {
		Set<ConstraintViolation<Concert>> violations = validator.validate(concert);
		if(violations.isEmpty()) {
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
