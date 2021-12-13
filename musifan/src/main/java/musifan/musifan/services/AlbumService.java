package musifan.musifan.services;

import java.util.ArrayList;
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

import musifan.musifan.entity.Album;
import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.LigneAlbum;
import musifan.musifan.exceptions.AlbumException;
import musifan.musifan.repositories.AlbumRepository;
import musifan.musifan.repositories.ChansonsRepository;
import musifan.musifan.repositories.LigneAlbumRepository;


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


	public Album save(musifan.musifan.dto.Album album) {
		Album albumEntity = musifan.musifan.dto.DtoToEntity.DtoAlbumToEntity(album);
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Album>> violations = validator.validate(albumEntity);
		if (violations.isEmpty()) {

			albumRepository.save(albumEntity);
			ligneAlbumRepository.saveAll(albumEntity.getLignesAlbums());
			Set<Chansons> chansons = albumEntity.getChansons();
			for(Chansons c : chansons) {
				chansonsService.save(c);
			}
			
			album.setId(albumEntity.getId());
		
			return albumEntity;
		} else {
			throw new AlbumException();
		}
	}

	public void delete(musifan.musifan.dto.Album album) {
		Album albumEnBase = albumRepository.findById(musifan.musifan.dto.DtoToEntity.DtoAlbumToEntity(album).getId()).orElseThrow(AlbumException::new);
		chansonsRepository.deleteByAlbum(albumEnBase);
		ligneAlbumRepository.deleteByAlbum(albumEnBase);
		albumRepository.delete(albumEnBase);
	}

	public List<musifan.musifan.dto.Album> allAlbum() {
		List<musifan.musifan.dto.Album> listeAlbumsDto = new ArrayList<musifan.musifan.dto.Album>();
		for(Album albumEntity : albumRepository.findAll()) {
			listeAlbumsDto.add(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumEntity));
		}
		return listeAlbumsDto;
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

	public musifan.musifan.dto.Album byIdWithChansons(Long id) {
		return musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumRepository.byKeyWithChansons(id).orElseThrow(AlbumException::new));
	}
	
	public musifan.musifan.dto.Album byIdWithArtistes(Long id) {
		return musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumRepository.byKeyWithArtistes(id).orElseThrow(AlbumException::new));
	}
	
	public musifan.musifan.dto.Album byIdWithChansonsAndArtistes(Long id) {
		
		return musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumRepository.byKeyWithChansonsAndArtistes(id).orElseThrow(AlbumException::new));
	}
	
	public List<musifan.musifan.dto.Album> byTitreIgnoreCase(String nom) {
		List<musifan.musifan.dto.Album> listeAlbumsDto = new ArrayList<musifan.musifan.dto.Album>();
		for(Album albumEntity : albumRepository.findByTitreIgnoreCase(nom)) {
			listeAlbumsDto.add(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumEntity));
		}
		return listeAlbumsDto;
	}
	
	public List<musifan.musifan.dto.Album> byTitreLikeIgnoreCase(String nom) {
		List<musifan.musifan.dto.Album> listeAlbumsDto = new ArrayList<musifan.musifan.dto.Album>();
		for(Album albumEntity : albumRepository.findByTitreIgnoreCase(nom)) {
			listeAlbumsDto.add(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumEntity));
		}
		return listeAlbumsDto;
	}
	
	public List<musifan.musifan.dto.Album> byTitreContainingIgnoreCase(String nom) {
		List<musifan.musifan.dto.Album> listeAlbumsDto = new ArrayList<musifan.musifan.dto.Album>();
		for(Album albumEntity : albumRepository.findByTitreIgnoreCase(nom)) {
			listeAlbumsDto.add(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(albumEntity));
		}
		return listeAlbumsDto;
	}
}
