package musifan.musifan.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import musifan.musifan.entity.JsonViews;
import musifan.musifan.dto.Utilisateur;
import musifan.musifan.services.ArtisteService;
import musifan.musifan.services.CommandeService;
import musifan.musifan.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins="*")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private ArtisteService artisteService;

	// Remonter un utilisateur par rapport a son id
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Utilisateur byId(@PathVariable("id") Long id) {
		return utilisateurService.byId(id);
	}

	// Remonter un utilisateur, par rapport a son id, avec sa liste d'artiste
	@GetMapping("/artistes/{id}")
	@JsonView(JsonViews.UtilisateurAvecArtiste.class)
	public Utilisateur byIdWithArtiste(@PathVariable("id") Long id) {
		return utilisateurService.byKeyWithArtistes(id);
	}

	//// TODO : Ne fonctionne pas car lazy initialize du a la remonter des
	//// publications de l'artiste
	// Remonte un utilisateur, par rapport a son id, avec sa liste d'artiste ainsi
	// que les publications liees aux artistes
	@GetMapping("/publications/{id}")
	@JsonView(JsonViews.UtilisateurAvecPublicationsArtiste.class)
	public Utilisateur byIdWithPublicationArtiste(@PathVariable("id") Long id) {
		return utilisateurService.byKeyWithArtistes(id);
	}

	// Remonter un utilisateur, par rapport a son id, avec sa liste de commande
	// ainsi que les concerts lies a la commande
	@GetMapping("/commandes/{id}")
	@JsonView(JsonViews.UtilisateurAvecCommandes.class)
	public Utilisateur byIdWithCommande(@PathVariable("id") Long id) {
		return utilisateurService.byKeyWithCommandes(id);
	}

	// Remonte un utilisateur, par rapport a son id, avec les albums de ses artistes
	// likes
	@GetMapping("/albums/{id}")
	@JsonView(JsonViews.UtilisateurAvecAlbumsArtiste.class)
	public Utilisateur byIdWithAlbumArtiste(@PathVariable("id") Long id) {
		return utilisateurService.byKeyWithArtistes(id);
	}

	// Creer un utilisateur
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurService.save(utilisateur));
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
		return musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto( utilisateurService.save(utilisateurEnBase));

	}

	// Ajoute un artiste a la liste d'artiste d'un utilisateur, par rapport a son id
	@PutMapping("artistes/{id}")
	@JsonView(JsonViews.UtilisateurAvecArtiste.class)
	public Utilisateur updateArtiste(@PathVariable("id") Long id, @Valid @RequestBody Utilisateur utilisateur) {
		musifan.musifan.entity.Utilisateur utilisateurEntity = musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur);
		utilisateurEntity.getLignesUtilisateurs().forEach(lu->{
			lu.getId().setUtilisateur(utilisateurEntity);
		});
		
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithArtistes(id);
		musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateurEnBase).setLignesUtilisateurs(musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateur).getLignesUtilisateurs());
		musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateurEnBase).getLignesUtilisateurs().forEach(lu -> {
			lu.getId().setUtilisateur(musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateurEnBase));
		});
		return musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(utilisateurService.addLigneUtilisateur(musifan.musifan.dto.DtoToEntity.DtoUtilisateurToUtilisateur(utilisateurEnBase)));
	}

	// Supprimer un artiste de la liste des artistes d'un utilisateur
	@DeleteMapping("{idUtilisateur}/artiste/{idArtiste}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteArtiste(@PathVariable("idUtilisateur") Long idUtilisateur,
			@PathVariable("idArtiste") Long idArtiste) {
		utilisateurService.deleteLigneUtilisateurByUtilisateur(utilisateurService.byId(idUtilisateur),
				artisteService.byId(idArtiste));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		utilisateurService.delete(utilisateurService.byId(id));
	}

}
