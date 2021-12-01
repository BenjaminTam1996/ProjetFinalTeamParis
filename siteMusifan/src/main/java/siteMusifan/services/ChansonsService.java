package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Chansons;
import siteMusifan.entity.Concert;
import siteMusifan.exceptions.ChansonsException;
import siteMusifan.repositories.AlbumRepository;
import siteMusifan.repositories.ChansonsRepository;


@Service
public class ChansonsService {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ChansonsRepository chansonsRepository;

	public void save(Chansons chansons) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Chansons>> violations = validator.validate(chansons);
		if (violations.isEmpty()) {
			chansonsRepository.save(chansons);
		} else {
			throw new ChansonsException();
		}
	}

	public List<Chansons> allChansons() {
		return chansonsRepository.findAll();
	}

	public Page<Chansons> chansonsFirstPage(int size) {
		Pageable pageable = PageRequest.of(0, size);
		return chansonsRepository.findAll(pageable);
	}

	public Page<Chansons> chansonsNextPage(Page<Chansons> page) {
		return chansonsRepository.findAll(page.nextOrLastPageable());
	}

	public Page<Chansons> chansonsPreviousPage(Page<Chansons> page) {
		return chansonsRepository.findAll(page.previousOrFirstPageable());
	}

	public List<Chansons> byTitreIgnoreCase(String nom) {
		return chansonsRepository.findByTitreIgnoreCase(nom);
	}
	
	public List<Chansons> byTitreLikeIgnoreCase(String nom) {
		return chansonsRepository.findByTitreIgnoreCase(nom);
	}
	
	public List<Chansons> byTitreContainingIgnoreCase(String nom) {
		return chansonsRepository.findByTitreIgnoreCase(nom);
	}
}
