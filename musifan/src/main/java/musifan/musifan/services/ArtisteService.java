package musifan.musifan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
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
	
	public Artiste save(musifan.musifan.dto.Artiste artiste, Long id) {
		Artiste artisteEnBase = artisteRepository.findById(id).orElseThrow(ArtisteException::new);
		artisteEnBase.setDescription(artiste.getDescription() != null ? artiste.getDescription() : artisteEnBase.getDescription());
		artisteEnBase.setMail(artiste.getMail());
		artisteEnBase.setNom(artiste.getNom());
		artisteEnBase.setNomArtiste(artiste.getNomArtiste());
		artisteEnBase.setPrenom(artiste.getPrenom());
		//artisteEnBase.setPassword(artiste.getPassword());
		artisteEnBase.setPhotoBanniere(artiste.getPhotoBanniere());
		artisteEnBase.setPhotoProfil(artiste.getPhotoProfil()!= null ? artiste.getPhotoProfil() : artisteEnBase.getPhotoProfil());
		artisteEnBase.setTelephone(artiste.getTelephone());
		Set<ConstraintViolation<Artiste>> violations = validator.validate(artisteEnBase);
		if (violations.isEmpty()) {
			return artisteRepository.save(artisteEnBase);
		} else {
			throw new ArtisteException();
		}
	}
	
	public Artiste update(musifan.musifan.dto.Artiste artiste) {
		Artiste artisteEntity = musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artiste);
		Set<ConstraintViolation<Artiste>> violations = validator.validate(artisteEntity);
		if (violations.isEmpty()) {
			artisteEntity.setPassword(passwordEncoder.encode(artisteEntity.getPassword()));
			artisteEntity.setRole(Role.ROLE_ARTISTE);
			artisteEntity.setEnable(true);
			return artisteRepository.save(artisteEntity);
		} else {
			throw new ArtisteException();
		}
	}
	
	public void delete(musifan.musifan.dto.Artiste artiste) {
		Artiste artisteEntity = musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artiste);
		ligneUtilisateurRepository.deleteByArtiste(artisteEntity);
		ligneAlbumRepository.deleteByArtiste(artisteEntity);
		ligneConcertRepository.deleteByArtiste(artisteEntity);
		publicationRepository.deleteByArtiste(artisteEntity);
		artisteRepository.delete(artisteEntity);
	}
	
	public void delete(Long id) {
		delete(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.findById(id).orElseThrow(ArtisteException::new)));
	}
	
	public musifan.musifan.dto.Artiste byId(Long id) {
		return musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.findById(id).orElseThrow(ArtisteException::new));
	}
	
	public List<musifan.musifan.dto.Artiste> allArtiste() {
		List<musifan.musifan.dto.Artiste> listeArtisteDto = new ArrayList<musifan.musifan.dto.Artiste>();
		for(Artiste artisteEntity : artisteRepository.findAll()) {
			listeArtisteDto.add(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteEntity));
		}
		return listeArtisteDto;
	}
	
	//Remonter un artiste complet avec : ses albums, ses concerts, ses publications et ses utilisateurs
	public musifan.musifan.dto.Artiste byKeyWithArtisteComplet(Long id) {
		return musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.findByKeyWithArtisteComplet(id).orElseThrow(ArtisteException::new));
	}
	
	
	public musifan.musifan.dto.Artiste byKeyWithAlbums(Long key) {
		return musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.byKeyWithAlbums(key).orElseThrow(ArtisteException::new));
	}
	
	public musifan.musifan.dto.Artiste byKeyWithConcerts(Long key) {
		return musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.byKeyWithConcerts(key).orElseThrow(ArtisteException::new));
	}
	
	public musifan.musifan.dto.Artiste byKeyWithPublications(Long key) {
		return musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteRepository.byKeyWithPublications(key).orElseThrow(ArtisteException::new));
	}
	
	public List<musifan.musifan.dto.Artiste> byNomArtisteContainingIgnoreCase(String nom) {
		List<musifan.musifan.dto.Artiste> listeArtisteDto = new ArrayList<musifan.musifan.dto.Artiste>();
		for(Artiste artisteEntity : artisteRepository.findByNomArtisteContainingIgnoreCase(nom)) {
			listeArtisteDto.add(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteEntity));
		}
		return listeArtisteDto;
	}

	public List<musifan.musifan.dto.Artiste> byNomArtisteIgnoreCase(String nom){
		List<musifan.musifan.dto.Artiste> listeArtisteDto = new ArrayList<musifan.musifan.dto.Artiste>();
		for(Artiste artisteEntity : artisteRepository.findByNomArtisteIgnoreCase(nom)) {
			listeArtisteDto.add(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteEntity));
		}
		return listeArtisteDto;
	}
	
	@Transactional
	public List<musifan.musifan.dto.Artiste> byNomArtisteLikeIgnoreCase(String nom){
		List<musifan.musifan.dto.Artiste> listeArtisteDto = new ArrayList<musifan.musifan.dto.Artiste>();
		for(Artiste artisteEntity : artisteRepository.findByNomArtisteLikeIgnoreCase(nom)) {
			listeArtisteDto.add(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artisteEntity));
		}
		return listeArtisteDto;
	}
	
}
