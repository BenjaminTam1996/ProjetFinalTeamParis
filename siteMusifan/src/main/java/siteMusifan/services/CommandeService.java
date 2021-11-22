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

import siteMusifan.entity.Commande;
import siteMusifan.exceptions.CommandeException;
import siteMusifan.repositories.CommandeRepository;


public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	
	public void save(Commande commande) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Commande>> violations = validator.validate(commande);
		if (violations.isEmpty()) {
			commandeRepository.save(commande);
		} else {
			throw new CommandeException();
		}
	}


	public void delete(Commande commande) {
		Commande commandeEnBase = commandeRepository.findById(commande.getNumero()).orElseThrow(CommandeException::new);
		commandeRepository.delete(commandeEnBase);
	}

	public List<Commande> allCommande() {
		return commandeRepository.findAll();
	}


	public List<Commande> allWithConcerts() {
		return commandeRepository.allWithConcerts();
	}
	
	public Commande byKeyWithConcerts(Long numero) {
		return commandeRepository.byKeyWithConcerts(numero);
	}
}
