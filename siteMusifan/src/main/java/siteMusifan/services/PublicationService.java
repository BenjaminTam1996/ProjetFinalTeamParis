package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import siteMusifan.entity.Publication;
import siteMusifan.exceptions.PublicationException;
import siteMusifan.repositories.PublicationRepository;

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
		Publication commandeEnBase = publicationRepository.findById(publication.getId()).orElseThrow(PublicationException::new);
		publicationRepository.delete(commandeEnBase);
	}

	public List<Publication> allPublication() {
		return publicationRepository.findAll();
	}


}
