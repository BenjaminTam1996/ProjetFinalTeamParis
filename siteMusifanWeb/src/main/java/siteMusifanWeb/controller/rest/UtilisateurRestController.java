package siteMusifanWeb.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import siteMusifan.entity.Commande;
import siteMusifan.entity.JsonViews;
import siteMusifan.entity.Utilisateur;
import siteMusifan.services.CommandeService;
import siteMusifan.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private CommandeService commandeService;

	// Remonter un utilisateur par rapport a son id
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Utilisateur byId(@PathVariable("id") Long id) {
		return utilisateurService.byId(id);
	}

	// Remonter un utilisateur, par rapport a son id, avec sa liste d'artiste
//	@GetMapping("/{id}")
//	@JsonView(JsonViews.UtilisateurAvecArtiste.class)
//	public Utilisateur byIdWithArtiste(@PathVariable("id") Long id) {
//		return utilisateurService.byKeyWithArtistes(id);
//	}

	//// TODO : Ne fonctionne pas car lazy initialize du a la remonter des
	//// publications de l'artiste
	// Remonte un utilisateur, par rapport a son id, avec sa liste d'artiste ainsi
	// que les publications liees aux artistes
//	@GetMapping("/{id}")
//	@JsonView(JsonViews.UtilisateurAvecPublicationsArtiste.class)
//	public Utilisateur byIdWithPublicationArtiste(@PathVariable("id") Long id) {
//		return utilisateurService.byKeyWithArtistes(id);
//	}

	//// TODO : Manque le traitement des concerts car lazy initialize du a la
	//// collection dans commande : ligneCommande pour trouver le concert
	// Remonter un utilisateur, par rapport a son id, avec sa liste de commande
	// ainsi que les concerts lies a la commande
//	@GetMapping("/{id}")
//	@JsonView(JsonViews.UtilisateurAvecCommandes.class)
//	public Utilisateur byIdWithCommande(@PathVariable("id") Long id) {
////		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandes(id);
////		utilisateurEnBase.getListeConcert().forEach(lc -> {
////			lc.getLignesCommandes().forEach(c -> {
////				Commande commande = commandeService.byKeyWithConcerts(c.getId().getCommande().getNumero());
////				utilisateurEnBase.addCommande(commande);
////			});
////		});
////		return utilisateurEnBase;
//		return utilisateurService.byKeyWithCommandes(id);
//	}

	//// TODO : Pas teste car devrait avoir lazy initialze du a la collection
	//// ligneAlbum dans Artiste
//	@GetMapping("/{id}")
//	@JsonView(JsonViews.UtilisateurAvecAlbumsArtiste.class)
//	public Utilisateur byIdWithAlbumArtiste(@PathVariable("id") Long id) {
//		return utilisateurService.byKeyWithArtistes(id);
//	}

	// Creer un utilisateur
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return utilisateurService.save(utilisateur);
	}

	// Mettre a jour un utilisateur par rapport a son id
	@PutMapping("{id}")
	@JsonView(JsonViews.Common.class)
	public Utilisateur update(@PathVariable("id") Long id, @Valid @RequestBody Utilisateur utilisateur,
			BindingResult br) {
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithArtistes(id);
		utilisateurEnBase.setMail(utilisateur.getMail());
		utilisateurEnBase.setNom(utilisateur.getNom());
		utilisateurEnBase.setPassword(utilisateur.getPassword());
		utilisateurEnBase.setPhotoProfil(utilisateur.getPhotoProfil());
		utilisateurEnBase.setPrenom(utilisateur.getPrenom());
		utilisateurEnBase.setPseudo(utilisateur.getPseudo());
		utilisateurEnBase.setTelephone(utilisateur.getTelephone());
		return utilisateurService.save(utilisateurEnBase);

	}

	// TODO : Faire deleteLigneUtilisateurByUtilisateur pour mettre a jour la liste
	// des artistes d'un utilisateur !!

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		utilisateurService.delete(id);
	}

}
