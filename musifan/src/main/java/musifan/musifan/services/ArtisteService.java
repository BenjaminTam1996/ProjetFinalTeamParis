package musifan.musifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Role;
import musifan.musifan.exceptions.ArtisteException;
import musifan.musifan.repositories.ArtisteRepository;
import musifan.musifan.repositories.LigneAlbumRepository;
import musifan.musifan.repositories.LigneConcertRepository;
import musifan.musifan.repositories.LigneUtilisateurRepository;
import musifan.musifan.repositories.PublicationRepository;

@Service
public class ArtisteService {

	@Autowired
	private ArtisteRepository artisteRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private LigneConcertRepository ligneConcertRepository;
	
	@Autowired
	private LigneAlbumRepository ligneAlbumRepository;

	@Autowired
	private LigneUtilisateurRepository ligneUtilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Artiste save(Artiste artiste) {
		Set<ConstraintViolation<Artiste>> violations = validator.validate(artiste);
		if (violations.isEmpty()) {
			artiste.setPassword(passwordEncoder.encode(artiste.getPassword()));
			artiste.setRole(Role.ROLE_ARTISTE);
			artiste.setEnable(true);
			return artisteRepository.save(artiste);
		} else {
			throw new ArtisteException();
		}
		
	}
	
	public void delete(Artiste artiste) {
		ligneUtilisateurRepository.deleteByArtiste(artiste);
		ligneAlbumRepository.deleteByArtiste(artiste);
		ligneConcertRepository.deleteByArtiste(artiste);
		publicationRepository.deleteByArtiste(artiste);
		artisteRepository.delete(artiste);
	}
	
	public void delete(Long id) {
		delete(artisteRepository.findById(id).orElseThrow(ArtisteException::new));
	}
	
	public Artiste byId(Long id) {
		return artisteRepository.findById(id).orElseThrow(ArtisteException::new);
	}
	
	public List<Artiste> allArtiste() {
		return artisteRepository.findAll();
	}
	
	//Remonter un artiste complet avec : ses albums, ses concerts, ses publications et ses utilisateurs
	public Artiste byKeyWithArtisteComplet(Long id) {
		return artisteRepository.findByKeyWithArtisteComplet(id).orElseThrow(ArtisteException::new);
	}
	
	
	public Artiste byKeyWithAlbums(Long key) {
		return artisteRepository.byKeyWithAlbums(key).orElseThrow(ArtisteException::new);
	}
	
	public Artiste byKeyWithConcerts(Long key) {
		return artisteRepository.byKeyWithConcerts(key).orElseThrow(ArtisteException::new);
	}
	
	public Artiste byKeyWithPublications(Long key) {
		return artisteRepository.byKeyWithPublications(key).orElseThrow(ArtisteException::new);
	}
	
	public List<Artiste> byNomArtisteContainingIgnoreCase(String nom) {
		return artisteRepository.findByNomArtisteContainingIgnoreCase(nom);
	}

	public List<Artiste> byNomArtisteIgnoreCase(String nom){
		return artisteRepository.findByNomArtisteIgnoreCase(nom);
	}
	
	public List<Artiste> byNomArtisteLikeIgnoreCase(String nom){
		return artisteRepository.findByNomArtisteLikeIgnoreCase(nom);
	}
	
}
