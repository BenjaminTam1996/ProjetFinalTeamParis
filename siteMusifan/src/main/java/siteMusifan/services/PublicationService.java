package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.Commande;
import siteMusifan.entity.Publication;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.CommandeException;
import siteMusifan.exceptions.PublicationException;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.repositories.PublicationRepository;

@Service
public class PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;
	
	public void save(Publication publication) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Publication>> violations = validator.validate(publication);
		if (violations.isEmpty()) {
			publicationRepository.save(publication);
		} else {
			throw new PublicationException();
		}
	}


	public void delete(Publication publication) {
		Publication publicationEnBase = publicationRepository.findById(publication.getId()).orElseThrow(PublicationException::new);
		publicationRepository.delete(publicationEnBase);
	}

	public List<Publication> allPublication() {
		return publicationRepository.findAll();
	}
	
	public Publication byId(Long id) {
		return publicationRepository.findById(id).orElseThrow(PublicationException::new);
	}
	
	public List<Publication> byArtiste(Artiste artiste ) {
		return publicationRepository.findByArtiste(artiste.getId());
	}


}
