package musifan.musifan.controller.rest;

import java.util.List;

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

import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.services.ArtisteService;


@RestController
@RequestMapping("/api/artiste")
@CrossOrigin(origins="*")
public class ArtisteRestController {

	@Autowired
	private ArtisteService artisteService;

	// Remonter tout les artistes
	@GetMapping("") 
	@JsonView(JsonViews.Common.class)
	public List<Artiste> all() {
		return artisteService.allArtiste();
	}

	//// Ne fonctionne pas car lob dans publication 
	//// Mais test fait sur album et concert => fonctionner
	// Remonter un artiste complet : avec ses albums, ses publications et ses
	// concerts, par rapport a son id.
	@GetMapping("/{id}")
	@JsonView(JsonViews.ArtisteComplet.class)
	public Artiste byId(@PathVariable("id") Long id) {
		return artisteService.byKeyWithArtisteComplet(id);
	}

	// Creer un artiste
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Artiste create(@Valid @RequestBody Artiste artiste, BindingResult br) {
		return artisteService.save(artiste);
	}

	// Mettre a jour un artiste par rapport a son id
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Artiste update(@PathVariable("id") Long id, @Valid @RequestBody Artiste artiste, BindingResult br) {
		Artiste artisteEnBase = artisteService.byId(id);
		artisteEnBase.setDescription(artiste.getDescription());
		artisteEnBase.setMail(artiste.getMail());
		artisteEnBase.setNom(artiste.getNom());
		artisteEnBase.setNomArtiste(artiste.getNomArtiste());
		artisteEnBase.setPrenom(artiste.getPrenom());
		artisteEnBase.setPassword(artiste.getPassword());
		artisteEnBase.setPhotoBanniere(artiste.getPhotoBanniere());
		artisteEnBase.setPhotoProfil(artiste.getPhotoProfil());
		artisteEnBase.setTelephone(artiste.getTelephone());
		return artisteService.save(artisteEnBase);
	}

	// Supprimer un artiste par rapport a son id
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		artisteService.delete(id);
	}

}
