package siteMusifan.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Artiste;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.repositories.LigneUtilisateurRepository;
import siteMusifan.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private LigneUtilisateurRepository ligneUtilisateurRepository;
	
	//Creation et edition d'un utilisateur
	public Utilisateur save(Utilisateur utilisateur) {
		Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
		if(violations.isEmpty()) {
			utilisateurRepository.save(utilisateur);
			ligneUtilisateurRepository.saveAll(utilisateur.getLignesUtilisateurs());
			return utilisateur;
		} else {
			System.out.println(violations);
			throw new UtilisateurException();
		}
	}
	
	//Supprimer un utilisateur
	public void delete(Utilisateur utilisateur) {
		Utilisateur utilisateurEnBase = utilisateurRepository.findById(utilisateur.getId()).orElseThrow(UtilisateurException::new);
		//Suppression des lignes utilisateur liees a l'utilisateur a supprimer
		ligneUtilisateurRepository.deleteByUtilisateur(utilisateurEnBase);
		//Suppression de l'utilisateur
		utilisateurRepository.delete(utilisateurEnBase);
	}
	
	public void delete(Long id) {
		delete(utilisateurRepository.findById(id).orElseThrow(UtilisateurException::new));
	}
	
	public void deleteLigneUtilisateurByUtilisateur(Utilisateur utilisateur, Artiste artiste) {
		ligneUtilisateurRepository.deleteByArtisteAndUtilisateur(artiste, utilisateur);
	}
	
	//Obtenir le utilisateur complet avec : sa liste de concert et sa liste d'artiste
	public Utilisateur byId(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(UtilisateurException::new);
	}

	public Utilisateur byKeyWithCommandesAndArtistes(Long id) {
		return utilisateurRepository.findByKeyWithCommandesAndArtistes(id).orElseThrow(UtilisateurException::new);
	}
	
	
	public Utilisateur byKeyWithArtistes(Long id) {
		return utilisateurRepository.byKeyWithArtistes(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur byKeyWithCommandes(Long id) {
		return utilisateurRepository.byKeyWithCommandes(id).orElseThrow(UtilisateurException::new);
	}
	
	
}
