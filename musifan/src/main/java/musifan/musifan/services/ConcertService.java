package musifan.musifan.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
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
	
	public void create(musifan.musifan.dto.Concert concert) {
		musifan.musifan.entity.Concert concertEntity = musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concert);
		Set<ConstraintViolation<Concert>> violations = validator.validate(concertEntity);
		if(violations.isEmpty()) {
			concertRepository.save(concertEntity);
			concertEntity.getLieu().getListeConcerts().add(concertEntity);
			ligneconcertRepository.saveAll(concertEntity.getLigneConcerts());

		}else {
			throw new ConcertException();
		}	
	}	
	
	public void update(musifan.musifan.dto.Concert concert) {
		musifan.musifan.entity.Concert concertEntity = musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concert);
		Set<ConstraintViolation<Concert>> violations = validator.validate(concertEntity);
		if(violations.isEmpty()) {
			concertEntity.getLieu().getListeConcerts().add(concertEntity);
			ligneconcertRepository.saveAll(concertEntity.getLigneConcerts());
			concertRepository.save(concertEntity);

		}else {
			throw new ConcertException();
		}	
	}	
	
	public void delete(musifan.musifan.dto.Concert concert) {
		Concert concertEnBase=concertRepository.findById(musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concert).getId()).orElseThrow(ConcertException::new);
		ligneconcertRepository.deleteByConcert(concertEnBase); 
		concertRepository.delete(concertEnBase); 
	}
	
	public List<musifan.musifan.dto.Concert> allConcert(){
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity : concertRepository.findAll()) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
	
	public List<musifan.musifan.dto.Concert> allByDate(LocalDate date){
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity : concertRepository.findByDate(date)) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
	
	public List<musifan.musifan.dto.Concert> allByLieu(Lieu lieu){
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity :concertRepository.findByLieu(lieu)) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
	
	public musifan.musifan.dto.Concert byId(Long id) {
		return musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertRepository.findById(id).orElseThrow(ConcertException::new));
	}
	
	public musifan.musifan.dto.Concert byKeyWithArtiste(Long id) {
		return musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertRepository.byKeyWithArtistes(id).orElseThrow(ArtisteException::new));
	}
	@Transactional
	public List<musifan.musifan.dto.Concert> ByNomIgnoreCase(String nom) {
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity :concertRepository.findByNomIgnoreCase(nom)) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
	
	public List<musifan.musifan.dto.Concert> ByNomLikeIgnoreCase(String nom) {
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity :concertRepository.findByNomIgnoreCase(nom)) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
	
	public List<musifan.musifan.dto.Concert> ByNomContainingIgnoreCase(String nom) {
		List<musifan.musifan.dto.Concert> listeConcertsDto = new ArrayList<musifan.musifan.dto.Concert>();
		for(Concert concertEntity :concertRepository.findByNomIgnoreCase(nom)) {
			listeConcertsDto.add(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concertEntity));
		}
		return listeConcertsDto;
	}
}
