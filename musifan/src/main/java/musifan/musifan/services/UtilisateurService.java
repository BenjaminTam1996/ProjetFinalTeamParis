package musifan.musifan.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Album;
import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Commande;
import musifan.musifan.entity.LigneUtilisateur;
import musifan.musifan.entity.Role;
import musifan.musifan.entity.Utilisateur;
import musifan.musifan.exceptions.UtilisateurException;
import musifan.musifan.repositories.CommandeRepository;
import musifan.musifan.repositories.LigneCommandeRepository;
import musifan.musifan.repositories.LigneUtilisateurRepository;
import musifan.musifan.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private Validator validator;

	@Autowired
	private LigneUtilisateurRepository ligneUtilisateurRepository;

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Creation et edition d'un utilisateur
	public Utilisateur save(musifan.musifan.dto.Utilisateur utilisateur) {
		Utilisateur utilisateurEntity = musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur);
		Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateurEntity);
		if (violations.isEmpty()) {
			utilisateurEntity.setPassword(passwordEncoder.encode(utilisateurEntity.getPassword()));
			utilisateurEntity.setRole(Role.ROLE_UTILISATEUR);
			utilisateurEntity.setEnable(true);
			utilisateurRepository.save(utilisateurEntity);
//			ligneUtilisateurRepository.saveAll(utilisateur.getLignesUtilisateurs());
			return utilisateurEntity;
		} else {
			throw new UtilisateurException();
		}
	}

	// Ajouter un artiste dans la liste des artistes d'un utilisateur
	public Utilisateur addLigneUtilisateur(Utilisateur utilisateur) {

		ligneUtilisateurRepository.saveAll(utilisateur.getLignesUtilisateurs());
		return utilisateur;
	}

	// Supprimer un utilisateur
	public void delete(musifan.musifan.dto.Utilisateur utilisateur) {
		Utilisateur utilisateurEnBase = utilisateurRepository.findById(musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur).getId())
				.orElseThrow(UtilisateurException::new);
		// Suppression des lignes utilisateur liees a l'utilisateur a supprimer
		ligneUtilisateurRepository.deleteByUtilisateur(utilisateurEnBase);
		// Suppression des lignes de commandes liees a la commande de l'utilisateur a
		// suppromer
		for (Commande c : musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur).getListeConcert()) {
			ligneCommandeRepository.deleteByCommande(c);

		}
		// Suppression des commandes liees a l'utilisateur a supprimer
		commandeRepository.deleteByUtilisateur(utilisateurEnBase);
		// Suppression de l'utilisateur
		utilisateurRepository.delete(utilisateurEnBase);
	}

//	public void delete(Long id) {
//		delete(musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurRepository.findById(id)).orElseThrow(UtilisateurException::new));
//	}

	public void deleteLigneUtilisateurByUtilisateur(musifan.musifan.dto.Utilisateur utilisateur, Artiste artiste) {
		ligneUtilisateurRepository.deleteByArtisteAndUtilisateur(artiste, musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur));
	}

	// Obtenir le utilisateur complet avec : sa liste de concert et sa liste
	// d'artiste
	public musifan.musifan.dto.Utilisateur byId(Long id) {
		return musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurRepository.findById(id).orElseThrow(UtilisateurException::new));
	}

	public musifan.musifan.dto.Utilisateur byKeyWithCommandesAndArtistes(Long id) {
		return  musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurRepository.findByKeyWithCommandesAndArtistes(id).orElseThrow(UtilisateurException::new));
	}

	public musifan.musifan.dto.Utilisateur byKeyWithArtistes(Long id) {
		return  musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurRepository.byKeyWithArtistes(id).orElseThrow(UtilisateurException::new));
	}

	public musifan.musifan.dto.Utilisateur byKeyWithCommandes(Long id) {
		return  musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurRepository.byKeyWithCommandes(id).orElseThrow(UtilisateurException::new));
	}

}
