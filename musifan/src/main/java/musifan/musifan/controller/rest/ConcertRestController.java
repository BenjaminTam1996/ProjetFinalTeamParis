package musifan.musifan.controller.rest;

import java.util.List;

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

import musifan.musifan.entity.Concert;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.services.ConcertService;

@RestController
@RequestMapping("/api/concert")
public class ConcertRestController {

	@Autowired
	private ConcertService concertService;
	
	@GetMapping("")	
	@JsonView({JsonViews.ConcertAvecLieu.class,})
	public List<Concert> all(){
		return concertService.allConcert();
	}
	
	@GetMapping("/{id}")
	@JsonView({JsonViews.ConcertAvecLieu.class,})
	public Concert byId(@PathVariable("id") Long id) {
		return concertService.byId(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView({JsonViews.ConcertAvecLieu.class,})
	public Concert create(@Valid @RequestBody Concert concert,BindingResult br) {
		concertService.save(concert);
		return concert;
	}
	
	@PutMapping("/{id}")
	@JsonView({JsonViews.ConcertAvecLieu.class,})
	public Concert update(@PathVariable("id") Long id,@Valid @RequestBody Concert concert,BindingResult br) {
		//On remonte le client en bdd pour récuperer sa bonne version
		Concert concertEnBase = concertService.byId(id);
		concertEnBase.setDate(concert.getDate());
		concertEnBase.setLieu(concert.getLieu());
		concertEnBase.setNbPlace(concert.getNbPlace());
		concertEnBase.setNom(concert.getNom());
		concertEnBase.setPrix(concert.getPrix());
		concertService.save(concert);
		return concert;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		concertService.delete(concertService.byId(id));
	}
}
