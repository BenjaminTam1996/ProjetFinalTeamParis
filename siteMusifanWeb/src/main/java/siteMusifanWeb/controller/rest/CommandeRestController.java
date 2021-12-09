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
import siteMusifan.entity.Concert;
import siteMusifan.entity.JsonViews;
import siteMusifan.services.CommandeService;
import siteMusifan.services.ConcertService;


@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	
	@Autowired
	private CommandeService commandeService;
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView({JsonViews.CommandeAvecConsert.class,})
	public Commande create(@Valid @RequestBody Commande commande,BindingResult br) {
		commandeService.save(commande);
		return commande;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		commandeService.delete(commandeService.byId(id));
	}
	
	@GetMapping("/{id}")
	@JsonView({JsonViews.CommandeAvecConsert.class,})
	public Commande byId(@PathVariable("id") Long id) {
		return commandeService.byId(id);
	}
}
