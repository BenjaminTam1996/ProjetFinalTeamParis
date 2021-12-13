package musifan.musifan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Album;
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
	
	public void save(musifan.musifan.dto.Commande commande) {
		Set<ConstraintViolation<Commande>> violations =  validator.validate(musifan.musifan.dto.DtoToEntity.DtoCommandeToEntity(commande));
		if (violations.isEmpty()) {
			commandeRepository.save(musifan.musifan.dto.DtoToEntity.DtoCommandeToEntity(commande));
			System.out.println(musifan.musifan.dto.DtoToEntity.DtoCommandeToEntity(commande).getLignesCommandes());
			ligneCommandeRepository.saveAll(musifan.musifan.dto.DtoToEntity.DtoCommandeToEntity(commande).getLignesCommandes());

		} else {
			throw new CommandeException();
		}
	}



	public musifan.musifan.dto.Commande byId(Long numero) {
		return musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commandeRepository.findById(numero).orElseThrow(CommandeException::new));
	}
	

	public void delete(musifan.musifan.dto.Commande commande) {
		Commande commandeEnBase = commandeRepository.findById(musifan.musifan.dto.DtoToEntity.DtoCommandeToEntity(commande).getNumero()).orElseThrow(CommandeException::new);
		ligneCommandeRepository.deleteByCommande(commandeEnBase);
		commandeRepository.delete(commandeEnBase);
	}

	public List<musifan.musifan.dto.Commande> allCommande() {
		List<musifan.musifan.dto.Commande> listeCommandeDto = new ArrayList<musifan.musifan.dto.Commande>();
		for(Commande commandeEntity : commandeRepository.findAll()) {
			listeCommandeDto.add(musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commandeEntity));
		}
		return listeCommandeDto;
	}


	public List<musifan.musifan.dto.Commande> allWithConcerts() {	
		List<musifan.musifan.dto.Commande> listeCommandeDto = new ArrayList<musifan.musifan.dto.Commande>();
		for(Commande commandeEntity : commandeRepository.allWithConcerts()) {
			listeCommandeDto.add(musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commandeEntity));
		}
		return listeCommandeDto;
	}
	
	public musifan.musifan.dto.Commande byKeyWithConcerts(Long numero) {
		return musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commandeRepository.byKeyWithConcerts(numero));
	}
}
