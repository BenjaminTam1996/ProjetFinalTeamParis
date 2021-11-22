package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Artiste;
import siteMusifan.exceptions.ArtisteException;
import siteMusifan.repositories.ArtisteRepository;
import siteMusifan.repositories.LigneAlbumRepository;
import siteMusifan.repositories.LigneConcertRepository;
import siteMusifan.repositories.LigneUtilisateurRepository;
import siteMusifan.repositories.PublicationRepository;

@Service
public class ArtisteService {
//
//	@Autowired
//	private ArtisteRepository artisteRepository;
//	
//	@Autowired
//	private Validator validator;
//	
//	@Autowired
//	private PublicationRepository publicationRepository;
//	
//	@Autowired
//	private LigneConcertRepository ligneConcertRepository;
//	
//	@Autowired
//	private LigneAlbumRepository ligneAlbumRepository;
//	
//	@Autowired
//	private LigneUtilisateurRepository ligneUtilisateurRepository;
//	
//	public void save(Artiste artiste) {
//		Set<ConstraintViolation<Artiste>> violations = validator.validate(artiste);
//		if (violations.isEmpty()) {
//			artisteRepository.save(artiste);
//			
//			//Voir comment faire update artise !!
//			
//		} else {
//			throw new ArtisteException();
//		}
//		
//	}
//	
//	public void delete(Artiste artiste) {
//		ligneUtilisateurRepository.deleteByArtiste(artiste);
//		//ligneAlbumRepository.deleteByArtiste(artiste);
//		ligneConcertRepository.deleteByArtiste(artiste);
//		//publicationRepository.deleteByArtiste(artiste);
//		artisteRepository.delete(artiste);
//	}
	
	//Remonter un artiste complet avec : ses albums, ses concerts, ses publications et ses utilisateurs
//	public Artiste byId(Long id) {
//		return artisteRepository.findByKeyWithAlbumsAndConcertsAndPublicationsAndUtilisateurs(id).orElseThrow(ArtisteException::new);
//	}
//	
//	public Artiste byKeyWithUtilisateur(Long key) {
//		return artisteRepository.byKeyWithUtilisateurs(key).orElseThrow(ArtisteException::new);
//	}
//	
//	public Artiste byKeyWithAlbums(Long key) {
//		return artisteRepository.byKeyWithAlbums(key).orElseThrow(ArtisteException::new);
//	}
//	
//	public Artiste byKeyWithConcerts(Long key) {
//		return artisteRepository.byKeyWithConcerts(key).orElseThrow(ArtisteException::new);
//	}
//	
//	public Artiste byKeyWithPublications(Long key) {
//		return artisteRepository.byKeyWithPublications(key).orElseThrow(ArtisteException::new);
//	}
//	
//	public List<Artiste> byNomArtisteContainingIgnoreCase(String nom) {
//		return artisteRepository.findByNomArtisteContainingIgnoreCase(nom);
//	}
	
}
