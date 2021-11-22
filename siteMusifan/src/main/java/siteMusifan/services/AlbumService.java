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

import siteMusifan.entity.Album;
import siteMusifan.entity.LigneAlbum;
import siteMusifan.exceptions.AlbumException;
import siteMusifan.repositories.AlbumRepository;
import siteMusifan.repositories.ChansonsRepository;
import siteMusifan.repositories.LigneAlbumRepository;



public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ChansonsRepository chansonsRepository;

	@Autowired
	private LigneAlbumRepository ligneAlbumRepository;
	public void save(Album album) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Album>> violations = validator.validate(album);
		if (violations.isEmpty()) {
			albumRepository.save(album);
		} else {
			throw new AlbumException();
		}
	}

//	public void delete(Client client) {
//		Client clientEnBase = clientRepository.findByIdWithCommandes(client.getId()).orElseThrow(ClientException::new);
//		clientEnBase.getCommandes().forEach(commande -> {
//			commande.setClient(null);
//			commandeRepository.save(commande);
//		});
//		clientRepository.delete(clientEnBase);
//	}

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

	//public Album byId(Long id) {
	//	return albumRepository.findByIdWithCommandes(id).orElseThrow(AlbumException::new);
	//}
}
