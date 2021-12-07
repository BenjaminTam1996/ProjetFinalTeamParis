package musifan.musifan.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Commande;
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

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	// Creation et edition d'un utilisateur
	public Utilisateur save(Utilisateur utilisateur) {
		Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
		if (violations.isEmpty()) {
			//// TODO : A ajouter lorsque la securite sera mise 
//			utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
//			utilisateur.setRoles(Arrays.asList(Role.ROLE_USER));
//			utilisateur.setEnable(true);
			utilisateurRepository.save(utilisateur);
			ligneUtilisateurRepository.saveAll(utilisateur.getLignesUtilisateurs());
			return utilisateur;
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
	public void delete(Utilisateur utilisateur) {
		Utilisateur utilisateurEnBase = utilisateurRepository.findById(utilisateur.getId())
				.orElseThrow(UtilisateurException::new);
		// Suppression des lignes utilisateur liees a l'utilisateur a supprimer
		ligneUtilisateurRepository.deleteByUtilisateur(utilisateurEnBase);
		// Suppression des lignes de commandes liees a la commande de l'utilisateur a
		// suppromer
		for (Commande c : utilisateur.getListeConcert()) {
			ligneCommandeRepository.deleteByCommande(c);

		}
		// Suppression des commandes liees a l'utilisateur a supprimer
		commandeRepository.deleteByUtilisateur(utilisateurEnBase);
		// Suppression de l'utilisateur
		utilisateurRepository.delete(utilisateurEnBase);
	}

	public void delete(Long id) {
		delete(utilisateurRepository.findById(id).orElseThrow(UtilisateurException::new));
	}

	public void deleteLigneUtilisateurByUtilisateur(Utilisateur utilisateur, Artiste artiste) {
		ligneUtilisateurRepository.deleteByArtisteAndUtilisateur(artiste, utilisateur);
	}

	// Obtenir le utilisateur complet avec : sa liste de concert et sa liste
	// d'artiste
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
