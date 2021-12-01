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
import musifan.musifan.entity.Publication;
import musifan.musifan.services.PublicationService;

@RestController
@RequestMapping("/api/publication")
public class PublicationRestController {

	@Autowired
	private PublicationService publicationService;
	
	@GetMapping("")	
	@JsonView({JsonViews.Common.class,})
	public List<Publication> all(){
		return publicationService.allPublication();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Publication byId(@PathVariable("id") Long id) {
		return publicationService.byId(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Publication create(@Valid @RequestBody Publication publication,BindingResult br) {
		publicationService.save(publication);
		return publication;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		publicationService.delete(publicationService.byId(id));
	}
	
}