package musifan.musifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Commande;
import musifan.musifan.exceptions.CommandeException;
import musifan.musifan.repositories.CommandeRepository;
import musifan.musifan.repositories.LigneCommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	public void save(Commande commande) {
		Set<ConstraintViolation<Commande>> violations = validator.validate(commande);
		if (violations.isEmpty()) {
			commandeRepository.save(commande);
			ligneCommandeRepository.saveAll(commande.getLignesCommandes());
		} else {
			throw new CommandeException();
		}
	}



	public Commande byId(Long numero) {
		return commandeRepository.findById(numero).orElseThrow(CommandeException::new);
	}
	

	public void delete(Commande commande) {
		Commande commandeEnBase = commandeRepository.findById(commande.getNumero()).orElseThrow(CommandeException::new);
		ligneCommandeRepository.deleteByCommande(commandeEnBase);
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
