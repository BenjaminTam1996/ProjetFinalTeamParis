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

import siteMusifan.entity.Chansons;
import siteMusifan.exceptions.ChansonsException;
import siteMusifan.repositories.AlbumRepository;
import siteMusifan.repositories.ChansonsRepository;


@Service
public class ChansonsService {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ChansonsRepository chansonsRepository;

	public void save(Chansons chansons) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Chansons>> violations = validator.validate(chansons);
		if (violations.isEmpty()) {
			chansonsRepository.save(chansons);
		} else {
			throw new ChansonsException();
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

//	public void delete(Chansons chansons) {
//		Chansons chansonsEnBase = chansonsRepository.findById(chansons.getId()).orElseThrow(ChansonsException::new);
//		albumRepository.removeChansonsFromAlbumByChansons(chansonsEnBase);
//		chansonsRepository.delete(chansonsEnBase);
//	}

	public List<Chansons> allChansons() {
		return chansonsRepository.findAll();
	}

	public Page<Chansons> chansonsFirstPage(int size) {
		Pageable pageable = PageRequest.of(0, size);
		return chansonsRepository.findAll(pageable);
	}

	public Page<Chansons> chansonsNextPage(Page<Chansons> page) {
		return chansonsRepository.findAll(page.nextOrLastPageable());
	}

	public Page<Chansons> chansonsPreviousPage(Page<Chansons> page) {
		return chansonsRepository.findAll(page.previousOrFirstPageable());
	}

//	public Chansons byId(Long id) {
//		return chansonsRepository.findByIdWithCommandes(id).orElseThrow(ChansonsException::new);
//	}
}
