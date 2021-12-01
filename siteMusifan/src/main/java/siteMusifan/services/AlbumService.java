package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import siteMusifan.entity.Album;
import siteMusifan.entity.Chansons;
import siteMusifan.exceptions.AlbumException;
import siteMusifan.repositories.AlbumRepository;
import siteMusifan.repositories.ChansonsRepository;
import siteMusifan.repositories.LigneAlbumRepository;


@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ChansonsRepository chansonsRepository;
	@Autowired
	private ChansonsService chansonsService;
	@Autowired
	private LigneAlbumRepository ligneAlbumRepository;


	public void save(Album album) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Album>> violations = validator.validate(album);
		if (violations.isEmpty()) {
			albumRepository.save(album);
			List<Chansons> chansons = album.getChansons();
			for(Chansons c : chansons) {
				chansonsService.save(c);
			}
		} else {
			throw new AlbumException();
		}
	}

	public void delete(Album album) {
		Album albumEnBase = albumRepository.findById(album.getId()).orElseThrow(AlbumException::new);
		chansonsRepository.deleteByAlbum(albumEnBase);
		ligneAlbumRepository.deleteByAlbum(albumEnBase);
		albumRepository.delete(albumEnBase);
	}

	public List<Album> allAlbum() {
		return albumRepository.findAll();
	}

	public Page<Album> albumFirstPage(int size) {
		Pageable pageable = PageRequest.of(0, size);
		return albumRepository.findAll(pageable);
	}

	public Page<Album> albumNextPage(Page<Album> page) {
		return albumRepository.findAll(page.nextOrLastPageable());
	}

	public Page<Album> albumPreviousPage(Page<Album> page) {
		return albumRepository.findAll(page.previousOrFirstPageable());
	}

	public Album byIdWithChansons(Long id) {
		return albumRepository.byKeyWithChansons(id).orElseThrow(AlbumException::new);
	}
	
	public Album byIdWithArtistes(Long id) {
		return albumRepository.byKeyWithArtistes(id).orElseThrow(AlbumException::new);
	}
	
	public Album byIdWithChansonsAndArtistes(Long id) {
		return albumRepository.byKeyWithChansonsAndArtistes(id).orElseThrow(AlbumException::new);
	}
	
	public List<Album> byTitreIgnoreCase(String nom) {
		return albumRepository.findByTitreIgnoreCase(nom);
	}
	
	public List<Album> byTitreLikeIgnoreCase(String nom) {
		return albumRepository.findByTitreIgnoreCase(nom);
	}
	
	public List<Album> byTitreContainingIgnoreCase(String nom) {
		return albumRepository.findByTitreIgnoreCase(nom);
	}
}
