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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.JsonViews;
import musifan.musifan.entity.Lieu;
import musifan.musifan.services.LieuService;

@RestController
@RequestMapping("/api/lieu")
public class LieuRestController {

	@Autowired
	private LieuService lieuService;
	
	@GetMapping("")	
	@JsonView({JsonViews.Common.class,})
	public List<Lieu> all(){
		return lieuService.allLieu();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.LieuAvecConcert.class)
	public Lieu byId(@PathVariable("id") Long id) {
		return lieuService.byId(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Lieu create(@Valid @RequestBody Lieu lieu,BindingResult br) {
		lieuService.save(lieu);
		return lieu;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		lieuService.delete(lieuService.byId(id));
	}
	
}
