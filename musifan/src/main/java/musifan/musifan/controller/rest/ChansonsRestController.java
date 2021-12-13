package musifan.musifan.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.services.ChansonsService;

@RestController
@RequestMapping("/api/chansons")
@CrossOrigin(origins ="*")
public class ChansonsRestController {
	
	@Autowired
	private ChansonsService chansonsService;
	
	@GetMapping("")	
	@JsonView({JsonViews.Common.class,})
	public List<Chansons> all(){
		return chansonsService.allChansons();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Chansons byId(@PathVariable("id") Long id) {
		return chansonsService.byId(id);
	}
	
//	@PostMapping("")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	@JsonView(JsonViews.Common.class)
//	public Chansons create(@Valid @RequestBody Chansons chansons,BindingResult br) {
//		chansonsService.save(chansons);
//		return chansons;
//	}
}
