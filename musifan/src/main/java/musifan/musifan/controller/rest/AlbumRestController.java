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

import musifan.musifan.entity.Album;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.services.AlbumService;

@RestController
@RequestMapping("/api/album")
public class AlbumRestController {

	@Autowired
	private AlbumService albumService;
	
	@GetMapping("")	
	@JsonView(JsonViews.AlbumAvecArtistes.class)
	public List<Album> all(){
		return albumService.allAlbum();
	}
	
	@GetMapping("/{id}")
	@JsonView({JsonViews.AlbumComplet.class,})
	public Album byId(@PathVariable("id") Long id) {
		return albumService.byIdWithChansonsAndArtistes(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView({JsonViews.AlbumComplet.class,})
	public Album create(@Valid @RequestBody Album album,BindingResult br) {
		album.getLignesAlbums().forEach(la->{
			la.getId().setAlbum(album);
		});
		albumService.save(album);
		return album;
	}
	
	@DeleteMapping("/{id}")
	@JsonView({JsonViews.AlbumComplet.class,})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		albumService.delete(albumService.byIdWithChansons(id));
	}
}
