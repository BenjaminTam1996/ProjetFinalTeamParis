package siteMusifan.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Concert;
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
		concert = byId(concert.getId());	//On va cherche le produit en base de donnée
		Concert concertEnBase=concertRepository.findById(concert.getId()).orElseThrow(LieuException::new);
		ligneconcertRepository.deleteByConcert(concertEnBase);
		concertRepository.delete(concertEnBase);
	}
	
	public List<Concert> allConcert(){
		return concertRepository.findAll();
	}
	
	public List<Concert> allByDate(LocalDate date){
		return concertRepository.findByDate(date);
	}
	
	public Concert byId(Long id) {
		return concertRepository.findById(id).orElseThrow(LieuException::new);
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
